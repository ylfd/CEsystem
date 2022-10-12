package cn.CEsystem.teacher.dao.impl;

import cn.CEsystem.enterprise.domain.ProjectStateAllInfo;
import cn.CEsystem.enterprise.domain.StuResumeList;
import cn.CEsystem.student.domain.ProjectAllInfo;
import cn.CEsystem.student.domain.StuResumes;
import cn.CEsystem.student.domain.StudentAllInfo;
import cn.CEsystem.teacher.dao.DaoTeacher;
import cn.CEsystem.teacher.domain.TeacherAllInfo;
import cn.CEsystem.teacher.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;

public class DaoTeacherImpl implements DaoTeacher {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public int register_teacher(TeacherAllInfo teacherAllInfo) {
        String sql_ = "select count(tid) from teachers where tnumber = ?";
        Long total = template.queryForObject(sql_, Long.class, teacherAllInfo.getTnumber());
        //防止插入重复
        if (total > 0) {
            return 0;
        }
        String sql = "insert into teachers(tid,tname,tnumber,tpassword,tschool,tcollege,ttitle,tphone,tsex) " +
                "values(NULL,?,?,?,?,?,?,?,?)";
        int count = template.update(sql, teacherAllInfo.getTname(), teacherAllInfo.getTnumber(), teacherAllInfo.getTpassword(), teacherAllInfo.getTschool(),
                teacherAllInfo.getTcollege(), teacherAllInfo.getTtitle(), teacherAllInfo.getTphone(), teacherAllInfo.getTsex());
        return count;
    }

    @Override
    public List<StuResumeList> returnStuScorce_Teacher(String tnumber, String ps_state) {
        List<StuResumeList> list = new ArrayList<StuResumeList>();

        String sql = "select * FROM students where steacher = ?";

        List<StudentAllInfo> state = template.query(sql, new BeanPropertyRowMapper<StudentAllInfo>(StudentAllInfo.class), tnumber);
        for (StudentAllInfo studentAllInfo : state) {
            String sno = studentAllInfo.getSsno();

            String sql0 = "select * from projectstatus where sno = ? and state = '3'";

            List<ProjectStateAllInfo> state_1 = template.query(sql0, new BeanPropertyRowMapper<ProjectStateAllInfo>(ProjectStateAllInfo.class), sno);
            for (ProjectStateAllInfo projectStateAllInfo : state_1) {
                StuResumeList stuResumeList = new StuResumeList();

                //1
                int id = projectStateAllInfo.getId();
                String pname = projectStateAllInfo.getPname();
                String company = projectStateAllInfo.getCompany();

                //2
                String sql2 = "select * from projects where id = ?";//id = 状态表的pid
                int pid = projectStateAllInfo.getPid();
                ProjectAllInfo projectAllInfo = template.queryForObject(sql2, new BeanPropertyRowMapper<ProjectAllInfo>(ProjectAllInfo.class), pid);
                //3
                String sql3 = "select * from resumes where rsno= ?";

                StuResumes stuResumes = template.queryForObject(sql3, new BeanPropertyRowMapper<StuResumes>(StuResumes.class), sno);
                //4
                stuResumeList.setId(id);
                stuResumeList.setPname(pname);
                stuResumeList.setCompany(company);
                stuResumeList.setPublishtime(projectAllInfo.getPublishtime());
                stuResumeList.setStuResumes(stuResumes);
                stuResumeList.setSubmittime(projectStateAllInfo.getSubmitTime());
                stuResumeList.setEvaluate(projectStateAllInfo.getEvaluate());

                list.add(stuResumeList);
            }
        }


        return list;
    }

}
