package cn.CEsystem.admi.service.impl;

import cn.CEsystem.admi.dao.DaoAdmi;
import cn.CEsystem.admi.dao.impl.DaoAdmiImpl;
import cn.CEsystem.admi.domain.AdmiAllInfo;
import cn.CEsystem.admi.service.ServiceAdmi;
import cn.CEsystem.enterprise.domain.EnterpriseAllInfo;
import cn.CEsystem.student.domain.PageBean;
import cn.CEsystem.student.domain.ProjectAllInfo;
import cn.CEsystem.student.domain.StudentAllInfo;
import cn.CEsystem.teacher.domain.TeacherAllInfo;
import org.omg.PortableInterceptor.INACTIVE;

import java.util.List;
import java.util.Map;

public class ServiceAdmiImpl implements ServiceAdmi {
   private DaoAdmi dao = new DaoAdmiImpl();

   @Override
   public int register_admi(AdmiAllInfo admiAllInfo) {
      return dao.register_admi(admiAllInfo);
   }

   @Override
   public PageBean<ProjectAllInfo> examineProject(String _currentPage, String _rows, Map<String, String[]> condition) {
      PageBean<ProjectAllInfo> pb = new PageBean<ProjectAllInfo>();

      int currentPage = Integer.parseInt(_currentPage);
      int rows = Integer.parseInt(_rows);
      //3.调用dao查询总记录数
      int totalCount = dao.countTotal_ExamineProject(condition);
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
      List<ProjectAllInfo> list = dao.findExamineProByPage(start,rows,condition);



      pb.setCurrentPage(currentPage);
      pb.setRows(rows);
      pb.setTotalCount(totalCount);
      pb.setList(list);
      pb.setTotalPage(totalPage);
      return pb;
   }

   @Override
   public ProjectAllInfo retuenSelectedProject(String id) {
      return dao.retuenProjectByID(id);
   }

   @Override
   public void oneProject_YesNo(String id) {
      dao.oneProject_YesNo(id);
   }

   @Override
   public void disagreeProject(String id) {
      dao.disagreeProject(id);
   }

   @Override
   public PageBean<StudentAllInfo> findStuByPage(String _currentPage, String _rows, Map<String, String[]> condition) {
      PageBean<StudentAllInfo> pb = new PageBean<StudentAllInfo>();

      int currentPage = Integer.parseInt(_currentPage);
      int rows = Integer.parseInt(_rows);
      //3.调用dao查询总记录数
      int totalCount = dao.countTotal_Stu(condition);
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
      List<StudentAllInfo> list = dao.findStuByPage(start,rows,condition);



      pb.setCurrentPage(currentPage);
      pb.setRows(rows);
      pb.setTotalCount(totalCount);
      pb.setList(list);
      pb.setTotalPage(totalPage);
      return pb;
   }

   @Override
   public void deleteOneStudent(String sid) {
      dao.deleteOneStudent(Integer.parseInt(sid));
   }

   @Override
   public StudentAllInfo returnStuInfoBySid(String sid) {
      return dao.returnStuInfoBySid(Integer.parseInt(sid));
   }

   @Override
   public void updateStuUser(StudentAllInfo studentAllInfo) {
      dao.updateStuUser(studentAllInfo);
   }

   @Override
   public PageBean<EnterpriseAllInfo> findProjectByPage(String _currentPage, String _rows, Map<String, String[]> condition) {
      PageBean<EnterpriseAllInfo> pb = new PageBean<EnterpriseAllInfo>();

      int currentPage = Integer.parseInt(_currentPage);
      int rows = Integer.parseInt(_rows);
      //3.调用dao查询总记录数
      int totalCount = dao.countTotal_Enterprise(condition);
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
      List<EnterpriseAllInfo> list = dao.findEnterpriseByPage(start,rows,condition);



      pb.setCurrentPage(currentPage);
      pb.setRows(rows);
      pb.setTotalCount(totalCount);
      pb.setList(list);
      pb.setTotalPage(totalPage);
      return pb;
   }

   @Override
   public void deleteOneEnterprise(String eid) {
      dao.deleteOneEnterprise(eid);
   }

   @Override
   public EnterpriseAllInfo returnEnterpriseInfoBySid(String eid) {
      return dao.returnEnterpriseInfoBySid(eid);
   }

   @Override
   public void updateEnterpriseUser(EnterpriseAllInfo enterpriseAllInfo) {

      dao.updateEnterpriseUser(enterpriseAllInfo);
   }

   @Override
   public PageBean<TeacherAllInfo> findTeacherByPage(String _currentPage, String _rows, Map<String, String[]> condition) {
      PageBean<TeacherAllInfo> pb = new PageBean<TeacherAllInfo>();

      int currentPage = Integer.parseInt(_currentPage);
      int rows = Integer.parseInt(_rows);
      //3.调用dao查询总记录数
      int totalCount = dao.countTotal_Teacher(condition);
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
      List<TeacherAllInfo> list = dao.findTeacherByPage(start,rows,condition);



      pb.setCurrentPage(currentPage);
      pb.setRows(rows);
      pb.setTotalCount(totalCount);
      pb.setList(list);
      pb.setTotalPage(totalPage);
      return pb;
   }

   @Override
   public void deleteOneTeacher(String tid) {
      dao.deleteOneTeacher(Integer.parseInt(tid));
   }

   @Override
   public TeacherAllInfo returnTeacherInfoBySid(String tid) {
      return dao.returnTeacherInfoBySid(Integer.parseInt(tid));
   }

   @Override
   public void updateTeacherUser(TeacherAllInfo teacherAllInfo) {
      dao.updateTeacherUser(teacherAllInfo);
   }


}
