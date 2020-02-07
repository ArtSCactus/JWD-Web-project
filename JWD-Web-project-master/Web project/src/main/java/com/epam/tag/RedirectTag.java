package com.epam.tag;

import exception.TagException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

public class RedirectTag extends TagSupport {
    private String url;
    private RedirectionType redirectionType;

    public void setUrl(String url) {
        this.url = url;
    }

    public void setRedirectionType(RedirectionType redirectionType) {
        this.redirectionType = redirectionType;
    }

    @Override
    public int doStartTag() throws JspException {
        HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
        HttpServletResponse response = (HttpServletResponse) pageContext.getResponse();
        switch (redirectionType) {
            case SERVER_SIDE:
                RequestDispatcher dispatcher = pageContext.getServletContext().getRequestDispatcher(url);
                try {
                    dispatcher.forward(request, response);
                } catch (ServletException | IOException e) {
                    throw new TagException(e);
                }
                break;
            case CLIENT_SIDE:
                try {
                    String baseURI = request.getRequestURI();
                    response.sendRedirect(baseURI+url);
                } catch (IOException e) {
                    throw new TagException(e);
                }
                break;
        }
        return SKIP_BODY;
    }
}
