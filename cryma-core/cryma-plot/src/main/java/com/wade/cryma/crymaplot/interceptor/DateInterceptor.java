package com.wade.cryma.crymaplot.interceptor;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DateInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String startDate = request.getParameter("startDate");
        String endDate = request.getParameter("endDate");

//        if ((startDate != null && endDate == null) || (startDate == null && endDate != null)
//                || (startDate != null && endDate != null && (startDate.matches("[0-9]+") != true || endDate.matches("[0-9]+") != true))) {
//            throw new Exception("Date format does not meet the Unix Time standard");
//        }
        return true;
    }
}