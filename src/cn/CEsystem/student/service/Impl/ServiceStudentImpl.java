package cn.CEsystem.student.service.Impl;

import cn.CEsystem.admi.domain.AdmiAllInfo;
import cn.CEsystem.enterprise.domain.EnterpriseAllInfo;
import cn.CEsystem.student.dao.DaoStudent;
import cn.CEsystem.student.dao.impl.DaoStudentImpl;
import cn.CEsystem.student.domain.*;
import cn.CEsystem.student.service.ServiceStudent;
import cn.CEsystem.teacher.domain.TeacherAllInfo;

import java.util.Date;
import java.util.List;
import java.util.Map;


public class ServiceStudentImpl implements ServiceStudent {
    private DaoStudent daoStudent = new DaoStudentImpl();
    @Override
    public StudentAllInfo login(User user) {
        return daoStudent.login(user);
    }

    @Override
    public EnterpriseAllInfo login_enterprise(User user) {
        return daoStudent.login_enterprise(user);
    }

    @Override
    public TeacherAllInfo login_teacher(User user) {
        return daoStudent.login_teacher(user);
    }

    @Override
    public AdmiAllInfo login_admi(User user) {
        return daoStudent.login_admi(user);
    }

    @Override
    public int register_stu(StudentAllInfo studentAllInfo) {
        return daoStudent.register_stu(studentAllInfo);
    }

    @Override
    public List<ProjectAllInfo> findAllProject() {
        return daoStudent.findAllProject();
    }

    @Override
    public ProjectAllInfo lookOneProject(String id) {
        return daoStudent.lookOneProject(Integer.parseInt(id));
    }

    @Override
    public PageBean<ProjectAllInfo> findProjectByPage(String _currentPage, String _rows, Map<String, String[]> condition) {
        PageBean<ProjectAllInfo> pb = new PageBean<ProjectAllInfo>();

        int currentPage = Integer.parseInt(_currentPage);
        int rows = Integer.parseInt(_rows);
        //3.调用dao查询总记录数
        int totalCount = daoStudent.findProject_TotalCount(condition);
        //4.计算总页码
        int totalPage = (totalCount % rows)  == 0 ? totalCount/rows : (totalCount/rows) + 1;
        //5分页条错误点击处理
        if(currentPage<1){
            currentPage=totalPage;
        }
        else if(currentPage>totalPage){
            currentPage=1;
        }
        //6.调用dao查询List集合
        //计算开始的记录索引
        int start = (currentPage - 1) * rows;
        List<ProjectAllInfo> list = daoStudent.findProByPage(start,rows,condition);



        pb.setCurrentPage(currentPage);
        pb.setRows(rows);
        pb.setTotalCount(totalCount);
        pb.setList(list);
        pb.setTotalPage(totalPage);
        return pb;
    }

    @Override
    public StuResumes havaNoStuResumes(String sno) {
        return daoStudent.returnStuResumes(sno);
    }

    @Override
    public int writeStuResumes(StuResumes stuResumes) {
        return daoStudent.writeStuResumes(stuResumes);
    }

    @Override
    public int sendResumeToE(String id, String name, String company, String sno) {
        return daoStudent.sendResumeToE(id,name,company,sno);
    }

    @Override
    public List<IfEmployedList> ifEmployedList(String ssno,String ps_state) {
        return daoStudent.ifEmployedList(ssno,ps_state);
    }

    @Override
    public StuResumes returnResumeBySno(String sno) {
        return daoStudent.returnResumeBySno(sno);
    }

    @Override
    public int submitProject_changeState(String id, String discriWord, Date date,String filepath,String filename) {
        int countInsretFilePath = daoStudent.submitProject_insertFilePath(Integer.parseInt(id),filepath,filename);
        int countInaertDiscriword = daoStudent.submitProject_changeState(id,discriWord,date);
        return countInaertDiscriword*countInsretFilePath;
    }

}
