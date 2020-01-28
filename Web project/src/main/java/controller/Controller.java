package controller;

import com.epam.commands.result.CommandResult;
import com.epam.factory.CommandFactory;
import com.epam.commands.main.Command;
import com.epam.dto.university.University;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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
    private static final Logger LOGGER = LogManager.getLogger(Controller.class);

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
        try {
            switch (commandResult.getExecutedCommandType()) {
                case POST:
                    response.sendRedirect(request.getContextPath() + commandResult.getRedirectUrl());
                    break;
                case GET:
                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(commandResult.getUrl());
                    dispatcher.forward(request, response);
            }
        } catch (ServletException e) {
        LOGGER.error("An error was occurred while command executing: "+e.getMessage());
        commandResult = new CommandResult("/WEB-INF/stacktrace page.jsp");
        request.setAttribute("requestUri", request.getRequestURI());
        request.setAttribute("servletName", request.getHttpServletMapping().getServletName());
        request.setAttribute("throwable", e);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(commandResult.getUrl());
        dispatcher.forward(request, response);
    }
      /* // try {
            if (commandResult != null && commandResult.getUrl() != null) {
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(commandResult.getUrl());
               // dispatcher.forward(request, response);
                response.sendRedirect(request.getContextPath()+commandResult.getRedirectUrl());
            } else {
                commandResult = new CommandResult("/WEB-INF/stacktrace page.jsp");
                System.out.println(request.getContextPath());
                response.sendRedirect(request.getContextPath() + commandResult.getUrl());
            }*/
      /*  } catch (ServletException e) {
            LOGGER.error("An error was occurred while command executing: "+e.getMessage());
            commandResult = new CommandResult("/WEB-INF/stacktrace page.jsp");
            request.setAttribute("requestUri", request.getRequestURI());
            request.setAttribute("servletName", request.getHttpServletMapping().getServletName());
            request.setAttribute("throwable", e);
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(commandResult.getUrl());
            dispatcher.forward(request, response);
        }*/

    }
}
