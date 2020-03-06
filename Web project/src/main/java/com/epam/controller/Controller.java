package com.epam.controller;

import com.epam.commands.common.Command;
import com.epam.commands.result.CommandResult;
import com.epam.connection.ConnectionPool;
import com.epam.factory.CommandFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Main page controller.
 *
 * @author ArtSCactus
 * @version 0.1.2
 */
@WebServlet("/controller")
public class Controller extends HttpServlet {
    private static final Logger LOGGER = LogManager.getLogger(Controller.class);

    @Override
    public void destroy() {
        ConnectionPool.getInstance().terminate();
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    private void processRequest(HttpServletRequest request,
                                HttpServletResponse response) throws ServletException, IOException {
        CommandResult commandResult;
        CommandFactory client = new CommandFactory();
        Command command = client.defineCommand(request);
        commandResult = command.execute(request);
        try {
            doResponse(commandResult, request, response);
        } catch (Exception e) {
            LOGGER.error("An error was occurred while command executing: " + e.getMessage());
            commandResult = new CommandResult("/WEB-INF/stacktrace page.jsp");
            request.setAttribute("requestUri", request.getRequestURI());
            request.setAttribute("servletName", request.getHttpServletMapping().getServletName());
            request.setAttribute("exception", e.getClass().getName());
            request.setAttribute("message", e.getMessage());
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(commandResult.getUrl());
            dispatcher.forward(request, response);
        }
    }

    private void doResponse(CommandResult commandResult, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        switch (commandResult.getExecutedCommandType()) {
            case POST:
                response.sendRedirect(request.getContextPath() + commandResult.getUrl());
                break;
            case GET:
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(commandResult.getUrl());
                dispatcher.forward(request, response);
        }
    }
}
