package com.praveen.restservices.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.praveen.restservices.exceptions.InvalidHeaderFieldException;

@Component
public class RequestHeaderInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

//		if (StringUtils.isBlank(request.getHeader("user-auth-key"))) {
//			throw new InvalidHeaderFieldException("Invalid request");
//		}

		return super.preHandle(request, response, handler);
	}
}
