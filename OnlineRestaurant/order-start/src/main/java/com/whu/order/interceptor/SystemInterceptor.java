package com.whu.order.interceptor;

import com.whu.order.types.SystemConstant;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


@Component
@Slf4j
public class SystemInterceptor implements HandlerInterceptor {

    private final AntPathMatcher matcher = new AntPathMatcher();

    /*系统3种请求路径*/
    private final List<String> systemPathList = Lists.newArrayList(
            SystemConstant.SYSTEM_API_ROOT,
            SystemConstant.SYSTEM_STATIC_PATH,
            SystemConstant.SYSTEM_MANAGE_PATH,
            "/onlinerestaurant/file/**");

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String requestURI = request.getRequestURI();

        //请求在这3种路径中
        for (String url : systemPathList) {
            if (matcher.match(url, requestURI)) {
                return true;
            }
        }
        log.warn("error requestURI [{}]", requestURI);
        return false;
    }
}
