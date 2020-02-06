package com.epam.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author ArtSCactus
 * @version 1.0
 */
public class LanguageFilter implements Filter {
    private static final String ENGLISH = "EN";
    private static final String RUSSIAN = "RU";
    private static final String LANGUAGE_ATTR = "language";

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession httpSession = request.getSession(true);
        String currentLanguage = (String) httpSession.getAttribute(LANGUAGE_ATTR);
        if (currentLanguage == null) {
            httpSession.setAttribute(LANGUAGE_ATTR, ENGLISH);
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }
}
