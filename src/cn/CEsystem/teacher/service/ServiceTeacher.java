package cn.CEsystem.teacher.service;

import cn.CEsystem.enterprise.domain.StuResumeList;
import cn.CEsystem.teacher.domain.TeacherAllInfo;

import java.util.List;

public interface ServiceTeacher {
    int register_teacher(TeacherAllInfo teacherAllInfo);

    List<StuResumeList> returnStuScorce_Teacher(String tnumber, String ps_state);

}
