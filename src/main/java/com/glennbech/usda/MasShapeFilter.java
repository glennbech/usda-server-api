package com.glennbech.usda;


import org.springframework.http.HttpStatus;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 */
public class MasShapeFilter implements Filter {

    private static String proxySecret;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        proxySecret = filterConfig.getServletContext().getInitParameter("mashapeProxySecret");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        final HttpServletRequest req = (HttpServletRequest) servletRequest;
        final HttpServletResponse res = (HttpServletResponse) servletResponse;

        final boolean isLocalhost = req.getServerName().equals("localhost");
        if (!isLocalhost && proxySecret.equals(req.getHeader("X-Mashape-Proxy-Secret")) == false) {
            res.setStatus(HttpStatus.FORBIDDEN.value());
            return;
        }
        filterChain.doFilter(servletRequest, servletResponse);
        res.addHeader("X-Mashape-Billing", "queries=1");
    }

    @Override
    public void destroy() {
    }
}
