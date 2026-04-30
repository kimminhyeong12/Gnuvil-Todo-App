package com.gnuvil.todo_list.config;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class LoginUserInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(
            HttpServletRequest request,
            HttpServletResponse response,
            Object handler
    ) {
        if (HttpMethod.OPTIONS.matches(request.getMethod())) {
            return true;
        }

        String userId = request.getHeader("X-USER-ID");

        if (userId == null) {
            throw new IllegalArgumentException("로그인이 필요합니다.");
        }

        request.setAttribute("id", Long.parseLong(userId));
        return true;
    }

}
