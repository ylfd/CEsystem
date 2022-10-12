package cn.CEsystem.enterprise.service.impl;

import cn.CEsystem.enterprise.dao.DaoEnterprise;
import cn.CEsystem.enterprise.dao.impl.DaoEnterpriseImpl;
import cn.CEsystem.enterprise.domain.EnterpriseAllInfo;
import cn.CEsystem.enterprise.domain.StuResumeList;
import cn.CEsystem.enterprise.service.ServiceEnterprise;
import cn.CEsystem.student.domain.ProjectAllInfo;
import cn.CEsystem.student.domain.StuResumes;
import org.omg.PortableInterceptor.INACTIVE;

import java.util.List;

public class ServiceEnterpriseImpl implements ServiceEnterprise{
    private DaoEnterprise dao = new DaoEnterpriseImpl();
    @Override
    public int register_enterprise(EnterpriseAllInfo enterpriseAllInfo) {
        return dao.register_enterprise(enterpriseAllInfo);
    }

    @Override
    public int publishProject(ProjectAllInfo projectAllInfo) {
        return dao.publishProject(projectAllInfo);
    }

    @Override
    public List<StuResumeList> examineStuResume(String ename,String ps_state) {
        return dao.examineStuResume(ename,ps_state);
    }

    @Override
    public StuResumes returnOneStuResume(String rid) {
        return dao.returnOneStuResume(Integer.parseInt(rid));
    }

    @Override
    public void agreeOneStuResume(String psid) {
        dao.agreeOneStuResume(Integer.parseInt(psid));
    }

    @Override
    public void disagreeOneStuResume(String psid) {
        dao.disagreeOneStuResume(Integer.parseInt(psid));
    }

    @Override
    public StuResumeList returnOneFinsihProjectInfo(String ps_id) {
        return dao.returnOneFinsihProjectInfo(Integer.parseInt(ps_id));
    }

    @Override
    public int saveStudentGrade(String ps_id, String grade) {
        return dao.saveStudentGrade(Integer.parseInt(ps_id),grade);
    }


}
