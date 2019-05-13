package com.oaec.sd.action;

import com.opensymphony.xwork2.ActionSupport;

public class HelloAction extends ActionSupport {

    public String hello(){
        System.out.println("Hello，Struts2!");
        return ERROR;
    }

}
