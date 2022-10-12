package cn.CEsystem.enterprise.domain;

public class EnterpriseAllInfo {
    private Integer eid;
    private String ename;
    private String enumber;
    private String epassword;
    private String eintroduce;
    private String eaddress;
    private String ephone;

    @Override
    public String toString() {
        return "EnterpriseAllInfo{" +
                "eid=" + eid +
                ", ename='" + ename + '\'' +
                ", enumber='" + enumber + '\'' +
                ", epassword='" + epassword + '\'' +
                ", eintroduce='" + eintroduce + '\'' +
                ", eaddress='" + eaddress + '\'' +
                ", ephone='" + ephone + '\'' +
                '}';
    }

    public Integer getEid() {
        return eid;
    }

    public void setEid(Integer eid) {
        this.eid = eid;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getEnumber() {
        return enumber;
    }

    public void setEnumber(String enumber) {
        this.enumber = enumber;
    }

    public String getEpassword() {
        return epassword;
    }

    public void setEpassword(String epassword) {
        this.epassword = epassword;
    }

    public String getEintroduce() {
        return eintroduce;
    }

    public void setEintroduce(String eintroduce) {
        this.eintroduce = eintroduce;
    }

    public String getEaddress() {
        return eaddress;
    }

    public void setEaddress(String eaddress) {
        this.eaddress = eaddress;
    }

    public String getEphone() {
        return ephone;
    }

    public void setEphone(String ephone) {
        this.ephone = ephone;
    }
}
