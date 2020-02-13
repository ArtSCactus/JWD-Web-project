package com.epam.listener;

import javax.servlet.http.*;
import java.util.Locale;

public class HttpSessionListenerImpl implements HttpSessionListener {
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        HttpSession session = se.getSession();
        session.setMaxInactiveInterval(600); // 10 minutes
        session.setAttribute("accountId", null);
        session.setAttribute("isUserAdmin", false);
        session.setAttribute("isUserDefined", false);
        session.setAttribute("lang", Locale.getDefault().getLanguage());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        se.getSession().invalidate();
    }
}

