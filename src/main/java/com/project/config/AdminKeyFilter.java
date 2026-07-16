package com.project.config;

import jakarta.annotation.Nonnull;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class AdminKeyFilter extends OncePerRequestFilter {

    @Value("${app.admin.import-key}")
    private String expectedKey;

    @Override
    protected void doFilterInternal(@Nonnull HttpServletRequest request,
                                    @Nonnull HttpServletResponse response,
                                    @Nonnull FilterChain filterChain) throws ServletException, IOException {

        if (!request.getRequestURI().startsWith("/admin")) {
            filterChain.doFilter(request, response);
            return;
        }

        String receivedKey = request.getHeader("X-Admin-Key");
        if (!expectedKey.equals(receivedKey)) {
            response.sendError(HttpServletResponse.SC_FORBIDDEN, "Invalid admin key");
            return;
        }

        filterChain.doFilter(request, response);
    }

}
