package com.glennbech.usda;


import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MasShapeFilter implements Filter {

    public static final String MASHAPE_PROXY_SECRET = "mashapeProxySecret";
    private static String proxySecret;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        proxySecret = filterConfig.getInitParameter(MASHAPE_PROXY_SECRET);
        if (proxySecret == null) {
            throw new ServletException("No context parameter with the name " + MASHAPE_PROXY_SECRET);
        }
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        final HttpServletRequest req = (HttpServletRequest) servletRequest;
        final HttpServletResponse res = (HttpServletResponse) servletResponse;

/*
        final boolean isLocalhost = req.getServerName().equals("localhost");
        if ((!isLocalhost && proxySecret.equals(req.getHeader("X-Mashape-Proxy-Secret")) == false) || !"true".equals(req.getHeader("X-Backdoor"))) {
            res.setStatus(HttpStatus.UNAUTHORIZED.value());
            return;
        }
*/
        filterChain.doFilter(servletRequest, servletResponse);
        res.addHeader("X-Mashape-Billing", "queries=1");
    }

    @Override
    public void destroy() {
        // do nothing
    }
}
