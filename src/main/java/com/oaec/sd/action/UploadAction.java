package com.oaec.sd.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import java.io.File;

/**
 * 文件上传Action
 */
public class UploadAction extends ActionSupport {

    private File file; // 得到上传的文件
    private String fileContentType; // 得到文件的类型
    private String fileFileName; // 得到文件的名称

    public String execute() throws Exception {

        System.out.println(file);
        System.out.println(fileContentType);
        System.out.println(fileFileName);

        //获取upload文件夹的项目路径
        String realPath = ServletActionContext.getServletContext().getRealPath("/upload");
        //获取上传文件的文件夹对象
        File folder = new File(realPath);

        if(!folder.exists()){
            folder.mkdirs();
        }

        //创建目标文件
        File targetFile = new File(folder, fileFileName);

        //把上传的文件file保存到目标文件targetFile中
        FileUtils.copyFile(file, targetFile);

        return SUCCESS;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public void setFileContentType(String fileContentType) {
        this.fileContentType = fileContentType;
    }

    public void setFileFileName(String fileFileName) {
        this.fileFileName = fileFileName;
    }
}
