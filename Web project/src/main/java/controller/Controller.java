package controller;

import com.epam.commands.main.CommandResult;
import com.epam.factory.CommandFactory;
import com.epam.commands.main.Command;
import com.epam.model.entity.university.University;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/controller")
public class Controller extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        ServletContext servletContext = config.getServletContext();
        servletContext.setAttribute("faculties", University.getInstance().getFaculties());
        super.init(config);
    }

    private void processRequest(HttpServletRequest request,
                                HttpServletResponse response) throws ServletException, IOException {
        CommandResult commandResult;
        CommandFactory client = new CommandFactory();
        Command command = client.defineCommand(request);
        commandResult = command.execute(request);
        //TODO: if you decided to make different parameter in CommandResult, make validation here.
        try {
            if (commandResult != null && commandResult.getUrl() != null) {
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(commandResult.getUrl());
                dispatcher.forward(request, response);
            } else {
                commandResult = new CommandResult("/WEB-INF/stacktrace page.jsp");

                response.sendRedirect(request.getContextPath() + commandResult);
            }
        } catch (ServletException e) {
            commandResult = new CommandResult("/WEB-INF/stacktrace page.jsp");
            request.setAttribute("requestUri", request.getRequestURI());
            request.setAttribute("servletName", request.getHttpServletMapping().getServletName());
            request.setAttribute("throwable", e);
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(commandResult.getUrl());
            dispatcher.forward(request, response);
        }

    }
}
