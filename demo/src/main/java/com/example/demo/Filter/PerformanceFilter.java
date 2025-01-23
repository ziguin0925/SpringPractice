package com.example.demo.Filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;

@WebFilter(urlPatterns = "/*") // 모든 요청에 PerformanceFilter를 적용.
public class PerformanceFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        // 1. 전처리 작업
//        long startTime = System.currentTimeMillis();
        System.out.println("Filter start");

        // 2. 서블릿(컨트롤러)또는 다음 필터
        filterChain.doFilter(request, response);

        // 3. 후처리 작업
//        System.out.println("Filter end");
//        long endTime = System.currentTimeMillis();
        System.out.println("Filter end ["+ ((HttpServletRequest)request).getRequestURI()+"]");
//        System.out.println(" time="+(endTime-startTime));
    }

}