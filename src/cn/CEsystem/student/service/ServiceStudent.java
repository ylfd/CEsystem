package cn.CEsystem.student.service;

import cn.CEsystem.admi.domain.AdmiAllInfo;
import cn.CEsystem.enterprise.domain.EnterpriseAllInfo;
import cn.CEsystem.student.domain.*;
import cn.CEsystem.teacher.domain.TeacherAllInfo;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface ServiceStudent {

    /**
     * 学生登录方法
     * @param user
     * @return
     */
    StudentAllInfo login(User user);

    /**
     * 企业登录
     * @param user
     * @return
     */
    EnterpriseAllInfo login_enterprise(User user);

    /**
     * 教师登录
     * @param user
     * @return
     */
    TeacherAllInfo login_teacher(User user);

    /**
     * 管理员登录
     * @param user
     * @return
     */
    AdmiAllInfo login_admi(User user);

    /**
     * 学生注册
     * @param studentAllInfo
     * @return
     */
    int register_stu(StudentAllInfo studentAllInfo);

    /**
     * 查看所有项目的list
     * @return
     */
    List<ProjectAllInfo> findAllProject();

    /**
     * 查看一个项目的详情
     * @param id
     * @return
     */
    ProjectAllInfo lookOneProject(String id);

    /**
     * 分页条件查询
     * @param currentPage
     * @param rows
     * @param condition
     * @return
     */
    PageBean<ProjectAllInfo> findProjectByPage(String currentPage, String rows, Map<String, String[]> condition);


    StuResumes havaNoStuResumes(String sno);

    int writeStuResumes(StuResumes stuResumes);

    int sendResumeToE(String id, String name, String company, String sno);

    List<IfEmployedList> ifEmployedList(String ssno,String ps_state);

    StuResumes returnResumeBySno(String sno);

    int submitProject_changeState(String id, String discriWord, Date date,String filepath,String filename);
}
