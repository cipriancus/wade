package com.wade.cryma.news.interceptor;

import com.wade.cryma.news.model.JenaOutputFormats;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.IOException;

public class RequestFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;

        String limit = request.getParameter("limit");
        String format = request.getParameter("format");

        if (limit == null) {
            limit = "25";
        } else {
            if (limit.matches("[0-9]+") != true)
                throw new ServletException("Limit must be numeric");
        }

        if (format == null) {
            format = "JSON-LD";
        } else {
            if (JenaOutputFormats.verify(format) == false)
                throw new ServletException("Format is not in list, please choose of the following " + JenaOutputFormats.formats);
        }

        final String finalLimit = limit;
        final String finalFormat = format;

        HttpServletRequest wrapper = new HttpServletRequestWrapper(request) {
            @Override
            public String getParameter(String name) {
                if (name.equals("limit"))
                    return finalLimit;
                if (name.equals("format"))
                    return finalFormat;
                return super.getParameter(name);
            }
        };

        try {
            filterChain.doFilter((ServletRequest) wrapper, servletResponse);
        } catch (Exception e) {

        }
    }

    @Override
    public void destroy() {

    }
}