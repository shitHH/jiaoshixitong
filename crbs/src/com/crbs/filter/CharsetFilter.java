package com.crbs.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @author lixiaobin
 * @version 1.0
 * @category 字符集过滤器
 * @date 2021/3/14  12:57
 */
@WebFilter("*")
public class CharsetFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String charSet="utf-8";
        servletRequest.setCharacterEncoding(charSet);
        servletResponse.setCharacterEncoding(charSet);
        filterChain.doFilter(servletRequest,servletResponse);
    }
}
