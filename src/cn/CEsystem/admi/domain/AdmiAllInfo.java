package cn.CEsystem.admi.domain;

public class AdmiAllInfo {
    private Integer aid;
    private String aname ;
    private String anumber ;
    private String apassword ;

    @Override
    public String toString() {
        return "AdmiAllInfo{" +
                "aid=" + aid +
                ", aname='" + aname + '\'' +
                ", anumber='" + anumber + '\'' +
                ", apassword='" + apassword + '\'' +
                '}';
    }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public String getAnumber() {
        return anumber;
    }

    public void setAnumber(String anumber) {
        this.anumber = anumber;
    }

    public String getApassword() {
        return apassword;
    }

    public void setApassword(String apassword) {
        this.apassword = apassword;
    }
}
