package cn.CEsystem.student.domain;
import java.text.SimpleDateFormat;
import java.util.Date;
public class ProjectAllInfo {
    private Integer id;
    private String name;
    private Date publishtime;
    private String content;
    private String company ;
    private String requirement;
    private String state;
    @Override
    public String toString() {
        return "ProjectAllInfo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", publishtime=" + publishtime +
                ", content='" + content + '\'' +
                ", company='" + company + '\'' +
                ", requirement='" + requirement + '\'' +
                ", state='" + state + '\'' +
                '}';
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPublishtime_T(){
        SimpleDateFormat formatter = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss");
        String date = formatter.format(this.publishtime);
        return date.substring(0,19);
    }


    public Date getPublishtime() {
        return publishtime;
    }

    public void setPublishtime(Date publishtime) {
        this.publishtime = publishtime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getRequirement() {
        return requirement;
    }

    public void setRequirement(String requirement) {
        this.requirement = requirement;
    }
}
