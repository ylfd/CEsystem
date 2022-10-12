package cn.CEsystem.student.dao;

import cn.CEsystem.admi.domain.AdmiAllInfo;
import cn.CEsystem.enterprise.domain.EnterpriseAllInfo;
import cn.CEsystem.student.domain.*;
import cn.CEsystem.teacher.domain.TeacherAllInfo;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface DaoStudent {
    StudentAllInfo login(User studentUser);

    EnterpriseAllInfo login_enterprise(User enterpriseUser);

    TeacherAllInfo login_teacher(User teacherUser);

    AdmiAllInfo login_admi(User admiUser);

    int register_stu(StudentAllInfo studentAllInfo);

    List<ProjectAllInfo> findAllProject();

    ProjectAllInfo lookOneProject(int id);

    /**
     * 查询总记录
     * @return
     * @param condition
     */
    int findProject_TotalCount(Map<String, String[]> condition);

    /**
     * 分页查询每页记录
     * @param start
     * @param rows
     * @param condition
     * @return
     */
    List<ProjectAllInfo> findProByPage(int start, int rows, Map<String, String[]> condition);

    StuResumes returnStuResumes(String sno);

    int writeStuResumes(StuResumes stuResumes);

    int sendResumeToE(String id, String name, String company, String sno);

    List<IfEmployedList> ifEmployedList(String ssno,String ps_state);

    StuResumes returnResumeBySno(String sno);

    int submitProject_changeState(String id, String discriWord, Date date);

    int submitProject_insertFilePath(int id, String filepath, String filename);
}
