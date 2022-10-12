package cn.CEsystem.teacher.service.impl;

import cn.CEsystem.enterprise.domain.StuResumeList;
import cn.CEsystem.teacher.dao.DaoTeacher;
import cn.CEsystem.teacher.dao.impl.DaoTeacherImpl;
import cn.CEsystem.teacher.domain.TeacherAllInfo;
import cn.CEsystem.teacher.service.ServiceTeacher;

import java.util.List;

public class ServiceTeacherImpl implements ServiceTeacher {
    DaoTeacher dao = new DaoTeacherImpl();
    @Override
    public int register_teacher(TeacherAllInfo teacherAllInfo) {
        return dao.register_teacher(teacherAllInfo);
    }

    @Override
    public List<StuResumeList> returnStuScorce_Teacher(String tnumber, String ps_state) {
        return dao.returnStuScorce_Teacher(tnumber,ps_state);
    }


}
