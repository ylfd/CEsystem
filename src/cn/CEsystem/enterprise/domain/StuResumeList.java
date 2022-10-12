package cn.CEsystem.enterprise.domain;

import cn.CEsystem.student.domain.StuResumes;

import java.text.SimpleDateFormat;
import java.util.Date;

public class StuResumeList {
    private Integer id;//项目状态表id
    private String pname;//项目名称
    private String company;
    private Date publishtime;//项目发布时间
    private Date submittime;
    private String discription;//项目描述
    private String state;//项目状态
    private String file_path;
    private String file_name;
    private String evaluate;
    private StuResumes stuResumes;//学生简历

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getEvaluate() {
        return evaluate;
    }

    public void setEvaluate(String evaluate) {
        this.evaluate = evaluate;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public String getFile_path() {
        return file_path;
    }

    public void setFile_path(String file_path) {
        this.file_path = file_path;
    }

    public String getFile_name() {
        return file_name;
    }

    public void setFile_name(String file_name) {
        this.file_name = file_name;
    }

    public String getSubmittime() {
        SimpleDateFormat formatter = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss");
        String date = formatter.format(this.submittime);
        return date.substring(0,19);
    }

    public void setSubmittime(Date submittime) {
        this.submittime = submittime;
    }

    public Integer getId() {
        return id;
    }
    public String getStringid(){
        return String.valueOf(id);
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getPublishtime() {
        SimpleDateFormat formatter = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss");
        String date = formatter.format(this.publishtime);
        return date.substring(0,19);
    }

    public void setPublishtime(Date publishtime) {
        this.publishtime = publishtime;
    }

    public StuResumes getStuResumes() {
        return stuResumes;
    }

    public void setStuResumes(StuResumes stuResumes) {
        this.stuResumes = stuResumes;
    }
}
