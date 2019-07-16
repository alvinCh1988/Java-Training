package com.yao.demo.interceptor;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;


@Component
public class LoginIntercepter extends HandlerInterceptorAdapter {

	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {


		if (modelAndView.getModel() == null &&
			request.getSession().getAttribute("account") == null) {
			response.sendRedirect("/account/index");
		}
	}
}
