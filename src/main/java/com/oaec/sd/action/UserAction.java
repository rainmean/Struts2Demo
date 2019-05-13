package com.oaec.sd.action;

import com.oaec.sd.entity.User;
import com.oaec.sd.service.UserService;
import com.oaec.sd.service.impl.UserServiceImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import java.util.Map;

public class UserAction extends ActionSupport {

    private UserService userService;

    private String username;
    private String password;
    private String password2;

    private User user;

    public UserAction() {
        userService = new UserServiceImpl();
    }

    public String register() {

//        System.out.println("用户名：" + username);
//        System.out.println("密码：" + password);
//        System.out.println("确认密码：" + password2);

        if(username==null||username.equals("")||password==null||password.equals("")
            ||password2==null||password2.equals("")){
            return ERROR;
        }

        if(!password.equals(password2)){
            return ERROR;
        }

        int id = userService.register(username, password);
        if(id>0){
            return SUCCESS;
        }else{
            return ERROR;
        }
    }

    public String login(){
        Map<String, Object> resultMap = userService.login(username, password);
        if((Boolean)resultMap.get("ok")){
            User loginUser = (User)resultMap.get("user");
            //登录成功，把用户信息保存到session中
            ActionContext context = ActionContext.getContext();
            Map<String, Object> session = context.getSession();
            session.put("loginUser", loginUser);
            return SUCCESS;
        }else{
            addActionError(resultMap.get("error").toString());
            return INPUT;
        }
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setPassword2(String password2) {
        this.password2 = password2;
    }
    public void setUser(User user) {
        this.user = user;
    }
}
