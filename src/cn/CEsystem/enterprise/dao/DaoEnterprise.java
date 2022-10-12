package cn.CEsystem.enterprise.dao;

import cn.CEsystem.enterprise.domain.EnterpriseAllInfo;
import cn.CEsystem.enterprise.domain.StuResumeList;
import cn.CEsystem.student.domain.ProjectAllInfo;
import cn.CEsystem.student.domain.StuResumes;

import java.util.List;

public interface DaoEnterprise {
    int register_enterprise(EnterpriseAllInfo enterpriseAllInfo);

    int publishProject(ProjectAllInfo projectAllInfo);

    List<StuResumeList> examineStuResume(String ename,String ps_state);

    StuResumes returnOneStuResume(int rid);

    void agreeOneStuResume(int psid);

    void disagreeOneStuResume(int psid);

    StuResumeList returnOneFinsihProjectInfo(int ps_id);

    int saveStudentGrade(int ps_id, String grade);
}
