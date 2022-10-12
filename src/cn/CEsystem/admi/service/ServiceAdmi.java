package cn.CEsystem.admi.service;

import cn.CEsystem.admi.domain.AdmiAllInfo;
import cn.CEsystem.enterprise.domain.EnterpriseAllInfo;
import cn.CEsystem.student.domain.PageBean;
import cn.CEsystem.student.domain.ProjectAllInfo;
import cn.CEsystem.student.domain.StudentAllInfo;
import cn.CEsystem.teacher.domain.TeacherAllInfo;

import java.util.Map;

public interface ServiceAdmi {
    int register_admi(AdmiAllInfo admiAllInfo);

    PageBean<ProjectAllInfo> examineProject(String currentPage, String rows, Map<String, String[]> condition);

    ProjectAllInfo retuenSelectedProject(String id);

    void oneProject_YesNo(String id);

    void disagreeProject(String id);

    PageBean<StudentAllInfo> findStuByPage(String currentPage, String rows, Map<String, String[]> condition);

    void deleteOneStudent(String sid);

    StudentAllInfo returnStuInfoBySid(String sid);

    void updateStuUser(StudentAllInfo studentAllInfo);

    PageBean<EnterpriseAllInfo> findProjectByPage(String currentPage, String rows, Map<String, String[]> condition);

    void deleteOneEnterprise(String eid);

    EnterpriseAllInfo returnEnterpriseInfoBySid(String eid);

    void updateEnterpriseUser(EnterpriseAllInfo enterpriseAllInfo);

    PageBean<TeacherAllInfo> findTeacherByPage(String currentPage, String rows, Map<String, String[]> condition);

    void deleteOneTeacher(String tid);

    TeacherAllInfo returnTeacherInfoBySid(String tid);

    void updateTeacherUser(TeacherAllInfo teacherAllInfo);
}
