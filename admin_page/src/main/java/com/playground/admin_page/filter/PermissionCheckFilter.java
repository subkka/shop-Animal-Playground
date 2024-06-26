package com.playground.admin_page.filter;

import com.playground.admin_page.login.model.dto.AdminAccountDto;
import com.playground.admin_page.login.model.dto.Permission;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;

import java.io.IOException;
import java.util.Objects;

@Slf4j
@WebFilter(urlPatterns = {"/user/*"})
@Order(2)
public class PermissionCheckFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("PermissionCheckFilter init");
    }

    @Override
    public void destroy() {
        log.info("PermissionCheckFilter destroy");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("PermissionCheckFilter doFilter start...");

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String requestURI = request.getRequestURI();

        Object adminAccountSession = request.getSession().getAttribute("adminAccount");
        Permission currentPermission = ((AdminAccountDto) adminAccountSession).getPermission();
        log.debug("currentPermission: {}", currentPermission);

        if (Objects.requireNonNull(currentPermission) == Permission.STANDARD) {
            log.info("접근 권한 없음");
            response.sendRedirect(request.getContextPath() + "/access-limit");
            return;
        }

        try {
            filterChain.doFilter(servletRequest, servletResponse);
        } finally {
            log.info("[{}] LoginFilter doFilter End", requestURI);
        }
    }
}
