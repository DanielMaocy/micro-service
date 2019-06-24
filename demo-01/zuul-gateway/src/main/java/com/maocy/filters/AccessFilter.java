package com.maocy.filters;

import javax.servlet.http.HttpServletRequest;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

public class AccessFilter extends ZuulFilter {
	
	@Override
	public Object run() throws ZuulException {
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();
		System.out.printf("send %s request to %s \n", request.getMethod(), request.getRequestURL().toString());
		
		Object accessToken = request.getParameter("accessToken");
		if (accessToken == null) {
			System.out.println("Token为空!");
			ctx.setSendZuulResponse(false);
			ctx.setResponseStatusCode(401);
		}
		System.out.printf("Token : %s", accessToken);
		return null;
	}

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public int filterOrder() {
		return 0;
	}

	@Override
	public String filterType() {
		return "pre";
	}
}
