package com.karma.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.karma.workhistory.model.User;

@Component
public class AuthenticationInterceptor extends HandlerInterceptorAdapter {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String uri = request.getRequestURI();
		if (!uri.endsWith("login") && !uri.endsWith("logout")) {
			User userData = (User) request.getSession().getAttribute("LOGGEDIN_USER");
			if (userData == null) {
				response.sendRedirect("login.do");
				return false;
			}
		}
		return true;
	}
}
