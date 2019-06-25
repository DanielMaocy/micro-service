package com.maocy.filters;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class ThrowExceptionFilter extends ZuulFilter {

	@Override
	public boolean shouldFilter() {
		return false;
	}

	@Override
	public Object run() throws ZuulException {
		System.out.println("这是一个pre过滤器，将抛出一个RuntimeException异常。。。");
		try {
			doSomething();
		} catch (Exception e) {
			RequestContext ctx = RequestContext.getCurrentContext();
			ctx.set("error.status_code", HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			ctx.set("error.exception", e);
			ctx.set("throwable", e);
		}
		
		
		return null;
	}
	
	private void doSomething() {
		throw new RuntimeException("");
	}

	@Override
	public String filterType() {
		return "pre";
	}

	@Override
	public int filterOrder() {
		return 0;
	}

}
