package cn.CEsystem.admi.dao;

import cn.CEsystem.admi.domain.AdmiAllInfo;
import cn.CEsystem.enterprise.domain.EnterpriseAllInfo;
import cn.CEsystem.student.domain.ProjectAllInfo;
import cn.CEsystem.student.domain.StudentAllInfo;
import cn.CEsystem.teacher.domain.TeacherAllInfo;

import java.util.List;
import java.util.Map;

public interface DaoAdmi {
    int register_admi(AdmiAllInfo admiAllInfo);

    int countTotal_ExamineProject(Map<String, String[]> condition);

    List<ProjectAllInfo> findExamineProByPage(int start, int rows, Map<String, String[]> condition);

    ProjectAllInfo retuenProjectByID(String id);

    void oneProject_YesNo(String id);

    void disagreeProject(String id);

    int countTotal_Stu(Map<String, String[]> condition);

    List<StudentAllInfo> findStuByPage(int start, int rows, Map<String, String[]> condition);

    void deleteOneStudent(int sid);

    StudentAllInfo returnStuInfoBySid(int sid);

    void updateStuUser(StudentAllInfo studentAllInfo);

    int countTotal_Enterprise(Map<String, String[]> condition);

    List<EnterpriseAllInfo> findEnterpriseByPage(int start, int rows, Map<String, String[]> condition);

    void deleteOneEnterprise(String eid);

    EnterpriseAllInfo returnEnterpriseInfoBySid(String eid);

    void updateEnterpriseUser(EnterpriseAllInfo enterpriseAllInfo);

    int countTotal_Teacher(Map<String, String[]> condition);

    List<TeacherAllInfo> findTeacherByPage(int start, int rows, Map<String, String[]> condition);

    void deleteOneTeacher(int tid);

    TeacherAllInfo returnTeacherInfoBySid(int tid);

    void updateTeacherUser(TeacherAllInfo teacherAllInfo);
}
