package com.epam.listeners;

import javax.servlet.http.*;

public class HttpSessionListenerImpl implements HttpSessionListener {
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        HttpSession session = se.getSession();
        session.setMaxInactiveInterval(600); // 10 minutes
        session.setAttribute("isUserDefined", false);
        session.setAttribute("isUserAdmin", false);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        se.getSession().invalidate();
    }
}

