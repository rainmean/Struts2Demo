package com.oaec.sd.action;

import com.oaec.sd.entity.User;
import com.oaec.sd.service.UserService;
import com.oaec.sd.service.impl.UserServiceImpl;
import com.opensymphony.xwork2.ActionSupport;

import java.util.List;

/**
 * 增删改查例子
 */
public class CRUDAction extends ActionSupport {

    private UserService userService;

    //用户列表对象，用于页面显示数据
    private List<User> userList;
    //用户对象，用于接收和显示数据
    private User user;
    //用于接受页面传过来的数据
    private Integer id;

    public CRUDAction() {
        userService = new UserServiceImpl();
    }

    /**
     * execute()方法是action的默认执行方法
     * @return
     * @throws Exception
     */
    public String execute() throws Exception {
        System.out.println("execute方法被调用了....");
        return SUCCESS;
    }

    /**
     * 查看用户列表
     * @return
     */
    public String list(){
        //获取用户列表
        userList = userService.findAll();
        System.out.println(userList.size());
        return SUCCESS;
    }

    /**
     * 编辑用户
     * @return
     */
    public String edit(){
        if(id==null){
            user = new User();
        }else {
            user = userService.findById(id);
        }
        return SUCCESS;
    }

    /**
     * 保存用户
     * @return
     */
    public String save(){
        if(user.getId()==null){
            userService.create(user);
        }else{
            userService.update(user);
        }
        return SUCCESS;
    }

    public String delete(){
        if(id==null){
            addActionError("删除失败！id不能为空！");
        }else{
            User user = userService.findById(id);
            if(user!=null) {
                userService.delete(user);
                addActionMessage("删除成功！");
            }else{
                addActionError("删除失败！不存在此id的用户！");
            }
        }
        return SUCCESS;
    }

    /**
     * 验证方法，在执行此Action类的任何一个方法之前被调用，
     * 当validate()里调用过addActionError()方法，就证明验证不通过，自动跳转到INPUT结果
     */
//    public void validate() {
//        System.out.println("validate() 方法被调用了!!!!!!");
//
//        if(user!=null) {
//            if (user.getUsername() == null || user.getUsername().equals("")) {
//                addActionError("用户名不能为空！");
//            }
//            if (user.getPassword() == null || user.getPassword().equals("")) {
//                addActionError("密码不能为空！");
//            }
//            if (user.getSex() == null || user.getSex().equals("")) {
//                addActionError("性别不能为空！");
//            }
//        }
//    }

    /**
     * 只验证save方法
     */
    public void validateSave(){
        System.out.println("validateSave() 方法被调用了!!!!!!");
        if (user.getUsername() == null || user.getUsername().equals("")) {
            addActionError("用户名不能为空！");
        }
        if (user.getPassword() == null || user.getPassword().equals("")) {
            addActionError("密码不能为空！");
        }
        if (user.getSex() == null || user.getSex().equals("")) {
            addActionError("性别不能为空！");
        }
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
