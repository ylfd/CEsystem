package cn.CEsystem.student.domain;

import java.util.Date;

public class StuResumes {
    private Integer rid;
    private String rsno;
    private String rname ;
    private String rsex ;
    private String rnation;
    private String rbirthday ;
    private String rcity ;
    private String rpolitics ;
    private String rhealth ;
    private String rschool ;
    private String reducation ;
    private String rmajor ;
    private String rgraduationtime ;
    private String rcontact ;
    private String remail ;
    private String rcourse ;
    private String rcredential ;
    private String revaluation  ;


    @Override
    public String toString() {
        return "StuResumes{" +
                "rid=" + rid +
                ", rsno='" + rsno + '\'' +
                ", rname='" + rname + '\'' +
                ", rsex='" + rsex + '\'' +
                ", rnation='" + rnation + '\'' +
                ", rbirthday='" + rbirthday + '\'' +
                ", rcity='" + rcity + '\'' +
                ", rpolitics='" + rpolitics + '\'' +
                ", rhealth='" + rhealth + '\'' +
                ", rschool='" + rschool + '\'' +
                ", reducation='" + reducation + '\'' +
                ", rmajor='" + rmajor + '\'' +
                ", rgraduationtime='" + rgraduationtime + '\'' +
                ", rcontact='" + rcontact + '\'' +
                ", remail='" + remail + '\'' +
                ", rcourse='" + rcourse + '\'' +
                ", rcredential='" + rcredential + '\'' +
                ", revaluation='" + revaluation + '\'' +
                '}';
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public String getRsno() {
        return rsno;
    }

    public void setRsno(String rsno) {
        this.rsno = rsno;
    }

    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname;
    }

    public String getRsex() {
        return rsex;
    }

    public void setRsex(String rsex) {
        this.rsex = rsex;
    }

    public String getRnation() {
        return rnation;
    }

    public void setRnation(String rnation) {
        this.rnation = rnation;
    }

    public String getRbirthday() {
        return rbirthday;
    }

    public void setRbirthday(String rbirthday) {
        this.rbirthday = rbirthday;
    }

    public String getRcity() {
        return rcity;
    }

    public void setRcity(String rcity) {
        this.rcity = rcity;
    }

    public String getRpolitics() {
        return rpolitics;
    }

    public void setRpolitics(String rpolitics) {
        this.rpolitics = rpolitics;
    }

    public String getRhealth() {
        return rhealth;
    }

    public void setRhealth(String rhealth) {
        this.rhealth = rhealth;
    }

    public String getRschool() {
        return rschool;
    }

    public void setRschool(String rschool) {
        this.rschool = rschool;
    }

    public String getReducation() {
        return reducation;
    }

    public void setReducation(String reducation) {
        this.reducation = reducation;
    }

    public String getRmajor() {
        return rmajor;
    }

    public void setRmajor(String rmajor) {
        this.rmajor = rmajor;
    }

    public String getRgraduationtime() {
        return rgraduationtime;
    }

    public void setRgraduationtime(String rgraduationtime) {
        this.rgraduationtime = rgraduationtime;
    }

    public String getRcontact() {
        return rcontact;
    }

    public void setRcontact(String rcontact) {
        this.rcontact = rcontact;
    }

    public String getRemail() {
        return remail;
    }

    public void setRemail(String remail) {
        this.remail = remail;
    }

    public String getRcourse() {
        return rcourse;
    }

    public void setRcourse(String rcourse) {
        this.rcourse = rcourse;
    }

    public String getRcredential() {
        return rcredential;
    }

    public void setRcredential(String rcredential) {
        this.rcredential = rcredential;
    }

    public String getRevaluation() {
        return revaluation;
    }

    public void setRevaluation(String revaluation) {
        this.revaluation = revaluation;
    }
}
