package com.wenjiaquan.springcloud.dashboard.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import io.micrometer.core.instrument.util.StringUtils;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class AutoFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        //业务逻辑判断
        //首先获取request对象
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();
        //获取请求路径的url
        String uri = request.getRequestURI();
        System.out.println(uri);
        //放行user的请求
        if(uri.startsWith("/user")){
            //false 放行
            return false;
        }
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        //首先获取request对象
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();
        System.err.println("run:"+request.getRequestURI());
        //是否授权
        String token = request.getParameter("token");
        if(StringUtils.isEmpty(token)){
            //设置为false 就不会路由到后端的服务
            requestContext.setSendZuulResponse(false);
            //设置http响应的状态码 401代表未授权
            requestContext.setResponseStatusCode(401);
            //返回响应信息
            HttpServletResponse response = requestContext.getResponse();

            //response.setCharacterEncoding("utf-8");
            response.setContentType("application/json;charset=utf-8");
            try{
                response.getWriter().write("{\"code\":401,\"msg:\":\"未授权\"}");
            }catch (Exception e){
                e.printStackTrace();
            }

        }
        return null;
    }
}
