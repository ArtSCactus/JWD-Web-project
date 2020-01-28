package com.epam.commands.controlpanel;

import com.epam.commands.main.Command;
import com.epam.commands.result.CommandResult;
import com.epam.dto.PageContent;
import com.epam.dto.PageContentType;
import com.epam.service.AccountService;
import com.epam.service.ApplicationService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class LoadContentCommand implements Command {
    private static final String CONTROL_PANEL_PAGE_PATH = "/WEB-INF/jsp/applications admin panel.jsp";
    private static final String CONTENT_TYPE_ATTR_NAME = "type";

    @Override
    public CommandResult execute(HttpServletRequest request) {
        String typeValue = request.getParameter(CONTENT_TYPE_ATTR_NAME);
        PageContentType type = defineContentType(typeValue);
        PageContent content = new PageContent();
        content.setType(type);
        content.setContent(getContent(type));
        request.setAttribute("content", content);
        return new CommandResult(CONTROL_PANEL_PAGE_PATH);
    }

    private PageContentType defineContentType(String attrValue) {
        return PageContentType.valueOf(attrValue.toUpperCase());
    }

    private List<?> getContent(PageContentType type) {
        switch (type) {
            case APPLICATIONS:
                ApplicationService service = new ApplicationService();
                return service.getApplicationsList();
            case ACCOUNTS:
                AccountService accountService = new AccountService();
                return accountService.getAccountsList();
            case STUDENTS:
            case ADMISSIONS:
                return null;
            default:
                throw new IllegalStateException("Unexpected value: " + type);
        }
    }
}
