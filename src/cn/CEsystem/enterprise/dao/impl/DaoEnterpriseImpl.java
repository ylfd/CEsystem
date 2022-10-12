package cn.CEsystem.enterprise.dao.impl;

import cn.CEsystem.enterprise.dao.DaoEnterprise;
import cn.CEsystem.enterprise.domain.EnterpriseAllInfo;
import cn.CEsystem.enterprise.domain.ProjectStateAllInfo;
import cn.CEsystem.enterprise.domain.StuResumeList;
import cn.CEsystem.enterprise.util.JDBCUtils;
import cn.CEsystem.student.domain.FileSubmit;
import cn.CEsystem.student.domain.ProjectAllInfo;
import cn.CEsystem.student.domain.StuResumes;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;

public class DaoEnterpriseImpl implements DaoEnterprise {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public int register_enterprise(EnterpriseAllInfo enterpriseAllInfo) {
        String sql_ = "select count(eid) from enterprises where enumber = ? or ename = ? ";
        Long total = template.queryForObject(sql_, Long.class, enterpriseAllInfo.getEnumber(), enterpriseAllInfo.getEname());
//        System.out.println(total);
        if (total > 0) {
            return 0;
        }
        String sql = "insert into enterprises(eid,ename,enumber,epassword,eintroduce,eaddress,ephone) " +
                "values(NULL,?,?,?,?,?,?)";
        int count = template.update(sql, enterpriseAllInfo.getEname(), enterpriseAllInfo.getEnumber(), enterpriseAllInfo.getEpassword(),
                enterpriseAllInfo.getEintroduce(), enterpriseAllInfo.getEaddress(), enterpriseAllInfo.getEphone());
        return count;
    }

    @Override
    public int publishProject(ProjectAllInfo projectAllInfo) {
        String sql = "insert into projects(id,name,publishtime,content,company,requirement) " +
                "values(NULL,?,?,?,?,?)";
        int count = template.update(sql, projectAllInfo.getName(), projectAllInfo.getPublishtime(), projectAllInfo.getContent(), projectAllInfo.getCompany(),
                projectAllInfo.getRequirement());
        return count;
    }

    @Override
    public List<StuResumeList> examineStuResume(String ename, String ps_state) {
        List<StuResumeList> list = new ArrayList<StuResumeList>();

        String sql = new String();
        if (ps_state == null || "".equals(ps_state)) {
            sql = "select * from projectstatus where company = ?";
        } else if ("0".equals(ps_state)) {
            sql = "select * from projectstatus where company = ? and state = '0'";
        } else if ("1".equals(ps_state)) {
            sql = "select * from projectstatus where company = ? and state = '1'";
        } else if ("2".equals(ps_state)) {
            sql = "select * from projectstatus where company = ? and state = '2'";
        } else if ("3".equals(ps_state)) {
            sql = "select * from projectstatus where company = ? and state = '3'";
        }
        List<ProjectStateAllInfo> state = template.query(sql, new BeanPropertyRowMapper<ProjectStateAllInfo>(ProjectStateAllInfo.class), ename);
        for (ProjectStateAllInfo projectStateAllInfo : state) {
            StuResumeList stuResumeList = new StuResumeList();

            //1
            int id = projectStateAllInfo.getId();
            String pname = projectStateAllInfo.getPname();
            String pstate = projectStateAllInfo.getState();

            //2
            String sql2 = "select * from projects where id = ?";//id = 状态表的pid
            int pid = projectStateAllInfo.getPid();
            ProjectAllInfo projectAllInfo = template.queryForObject(sql2, new BeanPropertyRowMapper<ProjectAllInfo>(ProjectAllInfo.class), pid);
            //3
            String sql3 = "select * from resumes where rsno= ?";
            String sno = projectStateAllInfo.getSno();
            StuResumes stuResumes = template.queryForObject(sql3, new BeanPropertyRowMapper<StuResumes>(StuResumes.class), sno);
            //4
            stuResumeList.setId(id);
            stuResumeList.setPname(pname);
//            stuResumeList.setPname(projectAllInfo.getCompany());
            stuResumeList.setState(pstate);
            stuResumeList.setPublishtime(projectAllInfo.getPublishtime());
            stuResumeList.setStuResumes(stuResumes);
            stuResumeList.setSubmittime(projectStateAllInfo.getSubmitTime());
            stuResumeList.setEvaluate(projectStateAllInfo.getEvaluate());

            list.add(stuResumeList);
        }


        return list;
    }

    @Override
    public StuResumes returnOneStuResume(int rid) {
        String sql = "select * from resumes where rid = ?";//id = 状态表的pid
        StuResumes stuResumes = template.queryForObject(sql, new BeanPropertyRowMapper<StuResumes>(StuResumes.class), rid);
        return stuResumes;
    }

    @Override
    public void agreeOneStuResume(int psid) {
        String sql = "update projectstatus set state = '1' where id = ?";
        template.update(sql, psid);
    }

    @Override
    public void disagreeOneStuResume(int psid) {
        String sql = "update projectstatus set state = '2' where id = ?";
        template.update(sql, psid);
    }

    @Override
    public StuResumeList returnOneFinsihProjectInfo(int ps_id) {

        String sql = "select * from projectstatus where id = ? ";
        ProjectStateAllInfo projectStateAllInfo = template.queryForObject(sql, new BeanPropertyRowMapper<ProjectStateAllInfo>(ProjectStateAllInfo.class), ps_id);

        StuResumeList stuResumeList = new StuResumeList();

        //1
        int id = projectStateAllInfo.getId();
        String pname = projectStateAllInfo.getPname();
        String discription = projectStateAllInfo.getDiscription();
        //2
        String sql2 = "select * from projects where id = ?";//id = 状态表的pid
        int pid = projectStateAllInfo.getPid();
        ProjectAllInfo projectAllInfo = template.queryForObject(sql2, new BeanPropertyRowMapper<ProjectAllInfo>(ProjectAllInfo.class), pid);
        //3
        String sql3 = "select * from resumes where rsno= ?";
        String sno = projectStateAllInfo.getSno();
        StuResumes stuResumes = template.queryForObject(sql3, new BeanPropertyRowMapper<StuResumes>(StuResumes.class), sno);
        //4
        String sql4 = "select * from file where ps_id= ?";
        FileSubmit fileSubmit = template.queryForObject(sql4, new BeanPropertyRowMapper<FileSubmit>(FileSubmit.class), ps_id);
        //5
        stuResumeList.setId(id);
        stuResumeList.setPname(pname);
        stuResumeList.setDiscription(discription);
        stuResumeList.setPublishtime(projectAllInfo.getPublishtime());
        stuResumeList.setSubmittime(projectStateAllInfo.getSubmitTime());
        stuResumeList.setStuResumes(stuResumes);

        stuResumeList.setFile_path(fileSubmit.getFile_path());
        stuResumeList.setFile_name(fileSubmit.getFile_name());
        return  stuResumeList;
    }

    @Override
    public int saveStudentGrade(int ps_id, String grade) {
        String sql = "update projectstatus set evaluate = ? where id = ?";
        template.update(sql,grade, ps_id);
        return 1;
    }
}
