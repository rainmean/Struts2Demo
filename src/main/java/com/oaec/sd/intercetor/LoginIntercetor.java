package com.oaec.sd.intercetor;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

import java.util.Map;

/**
 * 登录拦截器
 */
public class LoginIntercetor extends AbstractInterceptor {

    @Override
    public String intercept(ActionInvocation actionInvocation) throws Exception {

        System.out.println("登录拦截器被调用了！");

        //获取ActionContext上下文对象
        ActionContext context = actionInvocation.getInvocationContext();
        //通过ActionContext对象获取session对象
        Map<String, Object> session = context.getSession();
        //判断session中是否保存有登录用户的信息
        if(session.get("loginUser")!=null){
            return actionInvocation.invoke();//继续访问原本要访问的资源
        }else{
            context.put("error", "你还没有登录！");
            return "login";
        }
    }

}
