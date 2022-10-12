package cn.CEsystem.student.domain;

import cn.CEsystem.enterprise.domain.EnterpriseAllInfo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class IfEmployedList {
    private Integer id;//项目状态表id
    private Integer pid;//项目表pid
    private String pname;//项目名称
    private Date publishtime;//项目发布时间
    private String state;//项目状态
    private Date submitTime;//项目状态
    private EnterpriseAllInfo enterpriseAllInfo;//企业信息
    private FileSubmit fileSubmit;

    public FileSubmit getFileSubmit() {
        return fileSubmit;
    }

    public void setFileSubmit(FileSubmit fileSubmit) {
        this.fileSubmit = fileSubmit;
    }

    public String getSubmitTime() {
        SimpleDateFormat formatter = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss");
        String date = formatter.format(this.submitTime);
        return date.substring(0,10);
    }

    public void setSubmitTime(Date submitTime) {
        this.submitTime = submitTime;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public Date getPublishtime() {
        return publishtime;
    }
    public String getPublishtime_date() {
        SimpleDateFormat formatter = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss");
        String date = formatter.format(this.publishtime);
        return date.substring(0,10);
    }
    public void setPublishtime(Date publishtime) {
        this.publishtime = publishtime;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public EnterpriseAllInfo getEnterpriseAllInfo() {
        return enterpriseAllInfo;
    }

    public void setEnterpriseAllInfo(EnterpriseAllInfo enterpriseAllInfo) {
        this.enterpriseAllInfo = enterpriseAllInfo;
    }
}
