package cn.CEsystem.enterprise.service;

import cn.CEsystem.enterprise.domain.EnterpriseAllInfo;
import cn.CEsystem.enterprise.domain.StuResumeList;
import cn.CEsystem.student.domain.ProjectAllInfo;
import cn.CEsystem.student.domain.StuResumes;

import java.util.List;

public interface ServiceEnterprise {
    int register_enterprise(EnterpriseAllInfo enterpriseAllInfo);

    int publishProject(ProjectAllInfo projectAllInfo);

    List<StuResumeList> examineStuResume(String ename,String ps_state);

    StuResumes returnOneStuResume(String rid);

    void agreeOneStuResume(String psid);

    void disagreeOneStuResume(String psid);

    StuResumeList returnOneFinsihProjectInfo(String ps_id);

    int saveStudentGrade(String ps_id, String grade);
}
