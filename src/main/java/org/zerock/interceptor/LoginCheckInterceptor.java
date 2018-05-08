package org.zerock.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpRequest;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginCheckInterceptor extends HandlerInterceptorAdapter {
	
	public void saveDest(HttpServletRequest req) {
		
		String uri = req.getRequestURI();
		String query = req.getQueryString();
		
		if(query == null || query.equals("null")) {
			
			query = "";
			
		}else {
			
			query = "?"+query;
			
		}
		
		if(req.getMethod().equals("GET")) {
			req.getSession().setAttribute("dest", uri+query);
		}
		
		
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		boolean result = false;
		HttpSession session = request.getSession();
		
		
		if(session.getAttribute("member") != null) {
			
			result = true;
			
		}else {
			
			response.sendRedirect("/login/login");
		}
		
		return result;
	}
	
	

}
