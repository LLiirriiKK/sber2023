package ru.sbrf.example.filters;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;

@Component
public class TestFilter implements Filter {
    private int counter =0;
    private Logger logger = LoggerFactory.getLogger(TestFilter.class.getName());

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
        logger.info("Application stated!");

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        logger.info("doFilter: begin!");
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        counter++;
        logger.info("doFilter: current request is: {}", req.getRequestURI());
        logger.info("doFilter: counter of requests is: {}", counter);
        logger.info("doFilter: Context Path is: {}", req.getContextPath());
        logger.info("doFilter: Method is is: {}", req.getMethod());
        logger.info("doFilter: Content type is: {}", req.getContentType());
        logger.info("doFilter: Remote port is: {}", req.getRemotePort());
        logger.info("doFilter: Local port is: {}", req.getLocalPort());
        Map<String, String[]> params = req.getParameterMap();
        for (String param : params.keySet()){
            String[] values = params.get(param);
            String valueString = String.join(",", values);
            logger.info("doFilter: parameter "+ param +"=" + valueString);
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
        logger.info("Application terminated!");
    }
}
