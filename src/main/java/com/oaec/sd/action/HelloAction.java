package com.oaec.sd.action;

import com.opensymphony.xwork2.ActionSupport;

public class HelloAction extends ActionSupport {

    public String hello(){
        System.out.println("你好，Struts2Demo!");
        System.out.println(222222222);
        return ERROR;
    }

}
