package com.epam.commands.get;

import com.epam.commands.common.Command;
import com.epam.commands.result.CommandResult;
import com.epam.commands.result.CommandType;
import com.epam.model.dto.PageContent;
import com.epam.model.dto.entity.News;
import com.epam.service.NewsService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author ArtSCactus
 * @version 1.0
 */
public class ShowMainNewsCommand implements Command {
    private static final String REDIRECTION_URL = "/WEB-INF/jsp/main/news.jsp";

    @Override
    public CommandResult execute(HttpServletRequest request) {
        NewsService service = new NewsService();
        List<News> newsList = service.getAllNews();
        PageContent content = new PageContent();
        content.setContent(newsList);
        request.setAttribute("content",content);
        return new CommandResult(REDIRECTION_URL, CommandType.GET);
    }
}
