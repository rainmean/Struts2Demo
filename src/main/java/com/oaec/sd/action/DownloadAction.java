package com.oaec.sd.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * 文件下载Action
 */
public class DownloadAction extends ActionSupport {

    private InputStream inputStream;//输入流
    private String fileName;//文件名称

    public String execute() throws Exception {
        String realPath = ServletActionContext.getServletContext().getRealPath("/files");
        inputStream = new FileInputStream(realPath + File.separator +fileName);
        fileName = new String(fileName.getBytes(),"ISO8859-1");
        return SUCCESS;
    }

    public InputStream getInputStream() {
        return inputStream;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
