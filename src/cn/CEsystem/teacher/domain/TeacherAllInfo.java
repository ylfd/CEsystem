package cn.CEsystem.teacher.domain;

public class TeacherAllInfo {
    private Integer tid;
    private String tname ;
    private String tnumber ;
    private String tpassword ;
    private String tschool ;
    private String tcollege ;
    private String ttitle ;
    private String tphone ;
    private String tsex ;

    @Override
    public String toString() {
        return "TeacherAllInfo{" +
                "tid=" + tid +
                ", tname='" + tname + '\'' +
                ", tnumber='" + tnumber + '\'' +
                ", tpassword='" + tpassword + '\'' +
                ", tschool='" + tschool + '\'' +
                ", tcollege='" + tcollege + '\'' +
                ", ttitle='" + ttitle + '\'' +
                ", tphone='" + tphone + '\'' +
                ", tsex='" + tsex + '\'' +
                '}';
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getTnumber() {
        return tnumber;
    }

    public void setTnumber(String tnumber) {
        this.tnumber = tnumber;
    }

    public String getTpassword() {
        return tpassword;
    }

    public void setTpassword(String tpassword) {
        this.tpassword = tpassword;
    }

    public String getTschool() {
        return tschool;
    }

    public void setTschool(String tschool) {
        this.tschool = tschool;
    }

    public String getTcollege() {
        return tcollege;
    }

    public void setTcollege(String tcollege) {
        this.tcollege = tcollege;
    }

    public String getTtitle() {
        return ttitle;
    }

    public void setTtitle(String ttitle) {
        this.ttitle = ttitle;
    }

    public String getTphone() {
        return tphone;
    }

    public void setTphone(String tphone) {
        this.tphone = tphone;
    }

    public String getTsex() {
        return tsex;
    }

    public void setTsex(String tsex) {
        this.tsex = tsex;
    }
}
