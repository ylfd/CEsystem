package cn.CEsystem.enterprise.domain;

import java.util.Date;

public class ProjectStateAllInfo {
    private Integer id;
    private Integer pid;
    private String pname;
    private String company;
    private String sno;
    private String state;
    private String evaluate;
    private String discription;
    private Date submitTime;

    @Override
    public String toString() {
        return "ProjectStateAllInfo{" +
                "id=" + id +
                ", pid=" + pid +
                ", pname='" + pname + '\'' +
                ", company='" + company + '\'' +
                ", sno='" + sno + '\'' +
                ", state='" + state + '\'' +
                ", evaluate='" + evaluate + '\'' +
                ", discription='" + discription + '\'' +
                ", submitTime=" + submitTime +
                '}';
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public Date getSubmitTime() {
        return submitTime;
    }

    public void setSubmitTime(Date submitTime) {
        this.submitTime = submitTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getEvaluate() {
        return evaluate;
    }

    public void setEvaluate(String evaluate) {
        this.evaluate = evaluate;
    }
}
