package com.example.filters.pre;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

public class DebugFilter extends ZuulFilter {

    private static Logger logger = LoggerFactory.getLogger(DebugFilter.class);


    public DebugFilter() {
    }

    public String filterType() {
        return "pre";
    }

    public int filterOrder() {
        return 10000;
    }

    public boolean shouldFilter() {
        return true;
    }

    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        logger.info(String.format("%s,%s,%s", request.getMethod(), request.getRequestURI(), request.getProtocol()));
        return null;
    }
}

