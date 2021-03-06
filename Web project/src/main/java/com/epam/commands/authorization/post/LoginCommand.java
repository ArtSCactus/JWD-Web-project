package com.epam.commands.authorization.post;

import com.epam.commands.common.Command;
import com.epam.commands.result.CommandResult;
import com.epam.commands.result.CommandType;
import com.epam.model.dto.entity.Account;
import com.epam.service.AccountService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Optional;
public class LoginCommand implements Command {
    private static final String PARAM_NAME_LOGIN = "login";
    private static final String PARAM_NAME_PASSWORD = "password";
    private static final String MAIN_PAGE_PATH = "/WEB-INF/jsp/main/main.jsp";
    private static final String LOGIN_PAGE_PATH = "/WEB-INF/jsp/login.jsp";
    private static final String REDIRECT_URL = "/controller?command=show_main_page";

    public CommandResult execute(HttpServletRequest request) {
        String login = request.getParameter(PARAM_NAME_LOGIN);
        String pass = request.getParameter(PARAM_NAME_PASSWORD);
        HttpSession session = request.getSession(true);
        Optional<Account> account = findUser(login, pass);
        if (account.isPresent()) {
            Account currentAccount = account.get();
            if (currentAccount.isBlocked()){
                request.setAttribute("errorMessage", "This account is blocked.");
                return new CommandResult(LOGIN_PAGE_PATH, CommandType.GET);
            } else {
                session.setAttribute("isUserAdmin", currentAccount.isAdmin());
                session.setAttribute("accountId", currentAccount.getId());
                session.setAttribute("isUserDefined", true);
                return new CommandResult(REDIRECT_URL, CommandType.POST);
            }
        } else {
            request.setAttribute("errorMessage", "Wrong login or password. Try again");
            return new CommandResult(LOGIN_PAGE_PATH, CommandType.GET);
        }
    }

    private Optional<Account> findUser(String enterLogin, String enterPass) {
        AccountService service = new AccountService();
            return service.login(enterLogin, enterPass);
    }
}
