package cn.CEsystem.student.domain;

public class StudentAllInfo {
    private Integer sid;
    private  String sname;
    private  String ssno;
    private  String snumber;
    private  String spassword;
    private  String sschool;
    private  String scollege;
    private  String steacher;
    private  String ssex;
    private  String snation;
    private  String sphone;
    private  String smajor;
    private  Integer sevaluate;

    @Override
    public String toString() {
        return "StudentAllInfo{" +
                "sid=" + sid +
                ", sname='" + sname + '\'' +
                ", ssno='" + ssno + '\'' +
                ", snumber='" + snumber + '\'' +
                ", spassword='" + spassword + '\'' +
                ", sschool='" + sschool + '\'' +
                ", scollege='" + scollege + '\'' +
                ", steacher='" + steacher + '\'' +
                ", ssex='" + ssex + '\'' +
                ", snation='" + snation + '\'' +
                ", sphone='" + sphone + '\'' +
                ", smajor='" + smajor + '\'' +
                ", sevaluate=" + sevaluate +
                '}';
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSsno() {
        return ssno;
    }

    public void setSsno(String ssno) {
        this.ssno = ssno;
    }

    public String getSnumber() {
        return snumber;
    }

    public void setSnumber(String snumber) {
        this.snumber = snumber;
    }

    public String getSpassword() {
        return spassword;
    }

    public void setSpassword(String spassword) {
        this.spassword = spassword;
    }

    public String getSschool() {
        return sschool;
    }

    public void setSschool(String sschool) {
        this.sschool = sschool;
    }

    public String getScollege() {
        return scollege;
    }

    public void setScollege(String scollege) {
        this.scollege = scollege;
    }

    public String getSteacher() {
        return steacher;
    }

    public void setSteacher(String steacher) {
        this.steacher = steacher;
    }

    public String getSsex() {
        return ssex;
    }

    public void setSsex(String ssex) {
        this.ssex = ssex;
    }

    public String getSnation() {
        return snation;
    }

    public void setSnation(String snation) {
        this.snation = snation;
    }

    public String getSphone() {
        return sphone;
    }

    public void setSphone(String sphone) {
        this.sphone = sphone;
    }

    public String getSmajor() {
        return smajor;
    }

    public void setSmajor(String smajor) {
        this.smajor = smajor;
    }

    public Integer getSevaluate() {
        return sevaluate;
    }

    public void setSevaluate(Integer sevaluate) {
        this.sevaluate = sevaluate;
    }
}
