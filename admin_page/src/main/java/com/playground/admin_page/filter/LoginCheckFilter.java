package com.playground.admin_page.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;

import java.io.IOException;

@Slf4j
@WebFilter(urlPatterns = {"/main/*"})
@Order(1)
public class LoginCheckFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("LoginCheckFilter init()");
    }

    @Override
    public void destroy() {
        log.info("LoginCheckFilter destroy()");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
            HttpServletRequest request = (HttpServletRequest) servletRequest;
            HttpServletResponse response = (HttpServletResponse) servletResponse;
            String requestURI = request.getRequestURI();
            log.info("[{}] LoginFilter doFilter Start", requestURI);

            Object adminAccountSession = request.getSession().getAttribute("adminAccount");
            log.debug("adminAccountSession: {}", adminAccountSession);
            if (adminAccountSession == null) {
                log.info("login false");
                response.sendRedirect("http://localhost:8080/admin");
                return;
            }

            try {
                filterChain.doFilter(servletRequest, servletResponse);
            } finally {
                log.info("[{}] LoginFilter doFilter End", requestURI);
            }
    }
}
