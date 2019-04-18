package com.dhu.Interceptor;

import com.dhu.pojo.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AuthorizationInterceptor implements HandlerInterceptor {
    //不拦截 "/loginForm" 和"/login"
    private static final String[] IGNORE_URI = {"/book","/main","welcome","/login","/register"};
    /*
    * 进行处理器拦截用的，在controller处理之前被调用
    * 该方法返回为true拦截器才继续往下执行,返回false请求就结束了*/
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        //判断是否登录
        boolean flag = false;
        String servletPath = request.getServletPath();
        //判断是否需要拦截
        for(String uri:IGNORE_URI){
            if(servletPath.contains(uri)){
                flag = true;
                break;
            }
        }

        if(!flag){
            User user = (User)request.getSession().getAttribute("user");
            if(user == null){
                request.setAttribute("message","请先登录再访问网站");
                request.getRequestDispatcher("welcome").forward(request,response);
            }
            else{
                   //放行
                    flag = true;
            }
            if(flag && servletPath.contains("/admin")){
                if(user.getAuthority() == 0){
                    flag = false;
                    request.setAttribute("message","禁止访问管理员界面");
                    request.getRequestDispatcher("welcome").forward(request,response);
                }

            }

        }
        return flag;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
