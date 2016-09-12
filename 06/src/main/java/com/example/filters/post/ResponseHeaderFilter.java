package com.example.filters.post;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

import javax.servlet.http.HttpServletResponse;

public class ResponseHeaderFilter extends ZuulFilter {

    public ResponseHeaderFilter() {
    }

    public String filterType() {
        return "post";
    }

    public int filterOrder() {
        return 100;
    }

    public boolean shouldFilter() {
        return true;
    }


    public Object run() {
        HttpServletResponse servletResponse = RequestContext.getCurrentContext().getResponse();
        servletResponse.addHeader("X-Spring-Boot-Proxy", "Zuul");
        return null;
    }

}