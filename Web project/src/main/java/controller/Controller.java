package controller;

import com.epam.commands.CommandResult;
import com.epam.factory.CommandFactory;
import com.epam.commands.Command;
import com.epam.model.entity.University;

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
        if (commandResult !=null & commandResult.getUrl()!=null){
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(commandResult.getUrl());
            dispatcher.forward(request, response);
        } else {
            commandResult = new CommandResult("/WEB-INF/index.jsp");
            request.getSession().setAttribute("nullPage", "A null page occurred");
            response.sendRedirect(request.getContextPath()+commandResult);
        }

    }
}
