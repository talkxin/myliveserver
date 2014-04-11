package com.mylive.common.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mylive.common.GetProperties;

public class WebResourcesFilter implements Filter {

	private String resocespath = "";

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain arg2) throws IOException, ServletException {
		// TODO Auto-generated method stub
		if (resocespath != null && !resocespath.equals("")) {
			HttpServletRequest r = (HttpServletRequest) request;
			HttpServletResponse r1 = (HttpServletResponse) response;
			String path = r.getRequestURI().toString()
					.replaceAll("mylive/", "");
			r1.sendRedirect(resocespath + path);
		}
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		resocespath = GetProperties.getDefaultDevpModValue("app.resocespath");
	}

}
