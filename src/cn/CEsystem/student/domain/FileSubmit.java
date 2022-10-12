package cn.CEsystem.student.domain;

public class FileSubmit {
    private Integer id;
    private Integer ps_id;
    private String file_path;
    private String file_name;

    @Override
    public String toString() {
        return "FileSubmit{" +
                "id=" + id +
                ", ps_id=" + ps_id +
                ", file_path='" + file_path + '\'' +
                ", file_name='" + file_name + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPs_id() {
        return ps_id;
    }

    public void setPs_id(Integer ps_id) {
        this.ps_id = ps_id;
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
}
