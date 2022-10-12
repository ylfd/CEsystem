package cn.CEsystem.student.dao.impl;

import cn.CEsystem.admi.domain.AdmiAllInfo;
import cn.CEsystem.enterprise.domain.EnterpriseAllInfo;
import cn.CEsystem.enterprise.domain.ProjectStateAllInfo;
import cn.CEsystem.student.dao.DaoStudent;
import cn.CEsystem.student.domain.*;
import cn.CEsystem.student.util.JDBCUtils;
import cn.CEsystem.teacher.domain.TeacherAllInfo;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.*;

public class DaoStudentImpl implements DaoStudent {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    /**
     * 学生登录
     *
     * @param studentUser
     * @return
     */
    @Override
    public StudentAllInfo login(User studentUser) {
        try {
            String sql = "select * from students where snumber = ? and spassword = ?";
//            template.queryForMap(sql,studentUser.getUsername(),studentUser.getPassword());
            StudentAllInfo loginuser = template.queryForObject(sql, new BeanPropertyRowMapper<StudentAllInfo>(StudentAllInfo.class), studentUser.getUsername(), studentUser.getPassword());
            return loginuser;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    /**
     * 企业登录
     *
     * @param enterpriseUser
     * @return
     */
    @Override
    public EnterpriseAllInfo login_enterprise(User enterpriseUser) {
        try {
            String sql = "select * from enterprises where enumber = ? and epassword = ?";
//            template.queryForMap(sql,studentUser.getUsername(),studentUser.getPassword());
            EnterpriseAllInfo loginuser = template.queryForObject(sql, new BeanPropertyRowMapper<EnterpriseAllInfo>(EnterpriseAllInfo.class), enterpriseUser.getUsername(), enterpriseUser.getPassword());
            return loginuser;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 教师登录
     *
     * @param teacherUser
     * @return
     */
    @Override
    public TeacherAllInfo login_teacher(User teacherUser) {
        try {
            String sql = "select * from teachers where tnumber = ? and tpassword = ?";
//            template.queryForMap(sql,studentUser.getUsername(),studentUser.getPassword());
            TeacherAllInfo loginuser = template.queryForObject(sql, new BeanPropertyRowMapper<TeacherAllInfo>(TeacherAllInfo.class), teacherUser.getUsername(), teacherUser.getPassword());
            return loginuser;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 管理员登录
     *
     * @param admiUser
     * @return
     */
    @Override
    public AdmiAllInfo login_admi(User admiUser) {
        try {
            String sql = "select * from administrators  where anumber = ? and apassword = ?";
//            template.queryForMap(sql,studentUser.getUsername(),studentUser.getPassword());
            AdmiAllInfo loginuser = template.queryForObject(sql, new BeanPropertyRowMapper<AdmiAllInfo>(AdmiAllInfo.class), admiUser.getUsername(), admiUser.getPassword());
            return loginuser;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 学生注册
     *
     * @param studentAllInfo
     * @return
     */
    @Override
    public int register_stu(StudentAllInfo studentAllInfo) {
        String sql_ = "select count(sid) from students where ssno = ? or snumber = ? ";
        Long total = template.queryForObject(sql_, Long.class, studentAllInfo.getSsno(), studentAllInfo.getSnumber());
//        System.out.println(total);
        if (total > 0) {
            return 0;
        }
        String sql = "insert into students(sid,sname,ssno,snumber,spassword,sschool,scollege,steacher,ssex,snation,sphone,smajor,sevaluate) " +
                "values(NULL,?,?,?,?,?,?,?,?,?,?,?,NULL )";
        int count = template.update(sql, studentAllInfo.getSname(), studentAllInfo.getSsno(), studentAllInfo.getSnumber(), studentAllInfo.getSpassword(), studentAllInfo.getSschool(),
                studentAllInfo.getScollege(), studentAllInfo.getSteacher(), studentAllInfo.getSsex(), studentAllInfo.getSnation(), studentAllInfo.getSphone(),
                studentAllInfo.getSmajor());
        return count;
    }

    /**
     * 学生查看所有项目
     *
     * @return
     */
    @Override
    public List<ProjectAllInfo> findAllProject() {
        String sql = "select * from projects";
        List<ProjectAllInfo> projectAllInfos = template.query(sql, new BeanPropertyRowMapper<ProjectAllInfo>(ProjectAllInfo.class));
        return projectAllInfos;
    }

    @Override
    public ProjectAllInfo lookOneProject(int id) {
        String sql = "select * from projects where id = ?";
        ProjectAllInfo projectAllInfo = template.queryForObject(sql, new BeanPropertyRowMapper<ProjectAllInfo>(ProjectAllInfo.class), id);
        return projectAllInfo;
    }

    @Override
    public int findProject_TotalCount(Map<String, String[]> condition) {
        String sql = "select count(*) from projects where 1 = 1 ";
        StringBuilder sb = new StringBuilder(sql);
        //2.遍历map
        Set<String> keySet = condition.keySet();
        //定义参数的集合
        List<Object> params = new ArrayList<Object>();
        for (String key : keySet) {
            //排除分页条件参数
            if ("currentPage".equals(key) || "rows".equals(key) || "who".equals(key)) {
                continue;
            }
            //获取value
            String value = condition.get(key)[0];
            //判断value是否有值
            if (value != null && !"".equals(value)) {
                //处理datatime查询
                if ("publishtime".equals(key)) {
                    sb.append(" and convert(" + key + ",DATETIME) like ?");
                    params.add("%" + value + "%");
                    continue;
                }
                //有值
                sb.append(" and " + key + " like ? ");
                params.add("%" + value + "%");//？条件的值
            }
        }
        //查询审核通过的
        sb.append(" and state = ?");
        params.add("1");
        System.out.println(sb.toString());
        System.out.println(params);

        return template.queryForObject(sb.toString(), Integer.class, params.toArray());
//        return template.queryForObject(sql,Integer.class);
    }

    @Override
    public List<ProjectAllInfo> findProByPage(int start, int rows, Map<String, String[]> condition) {
        String sql = "select * from projects where 1 = 1 ";
        StringBuilder sb = new StringBuilder(sql);
        //2.遍历map
        Set<String> keySet = condition.keySet();
        //定义参数的集合
        List<Object> params = new ArrayList<Object>();
        for (String key : keySet) {
            //排除分页条件参数
            if ("currentPage".equals(key) || "rows".equals(key) || "who".equals(key)) {
                continue;
            }
            //获取value
            String value = condition.get(key)[0];
            //判断value是否有值
            if (value != null && !"".equals(value)) {
                //处理datatime查询
                if ("publishtime".equals(key)) {
                    sb.append(" and convert(" + key + ",DATETIME) like ?");
                    params.add("%" + value + "%");
                    continue;
                }
                //有值
                sb.append(" and " + key + " like ? ");
                params.add("%" + value + "%");//？条件的值
            }
        }
        //查询审核通过的
        sb.append(" and state = ?");
        params.add("1");
        //添加分页查询
        sb.append(" ORDER BY publishtime desc limit ?,? ");
        //添加分页查询参数值
        params.add(start);
        params.add(rows);
        System.out.println(sb.toString());

        return template.query(sb.toString(), new BeanPropertyRowMapper<ProjectAllInfo>(ProjectAllInfo.class), params.toArray());
    }

    @Override
    public StuResumes returnStuResumes(String sno) {
        try {
            String sql = "select * from resumes  where rsno = ?";
            StuResumes stuResumes = template.queryForObject(sql, new BeanPropertyRowMapper<StuResumes>(StuResumes.class), sno);
            return stuResumes;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public int writeStuResumes(StuResumes stuResumes) {
        String sql_ = "select count(rid) from resumes where rsno  = ?";
        Long total = template.queryForObject(sql_, Long.class, stuResumes.getRsno());
//        System.out.println(total);
        if (total > 0) {
            return 0;
        }
        String sql = "insert into resumes(rid,rsno ,rname,rsex ,rnation ,rbirthday ,rcity ,rpolitics ,rhealth,rschool,reducation," +
                "rmajor ,rgraduationtime ,rcontact ,remail ,rcourse,rcredential, revaluation) " +
                "values(NULL,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";


        int count = template.update(sql, stuResumes.getRsno(), stuResumes.getRname(), stuResumes.getRsex(), stuResumes.getRnation(), stuResumes.getRbirthday(),
                stuResumes.getRcity(), stuResumes.getRpolitics(), stuResumes.getRhealth(), stuResumes.getRschool(), stuResumes.getReducation(),
                stuResumes.getRmajor(), stuResumes.getRgraduationtime(), stuResumes.getRcontact(), stuResumes.getRemail(), stuResumes.getRcourse(),
                stuResumes.getRcredential(), stuResumes.getRevaluation());
        return count;
    }

    @Override
    public int sendResumeToE(String _id, String name, String company, String sno) {
        int id = Integer.parseInt(_id);
        String sql_ = "select count(id) from projectstatus where pid = ? and sno = ? ";
        Long total = template.queryForObject(sql_, Long.class,id,sno);
//        System.out.println(total);
        if(total>0){
            return 0;
        }
        String sql = "insert into projectstatus(id ,pid,pname,company,sno,state,evaluate) " +
                "values(NULL,?,?,?,?,?,NULL )";
        int count = template.update(sql, id, name, company, sno, "0");//项目状态表，state 0：就是企业未审核，1：已经审核，2：已近提交，项目结束
        return count;
    }

    /**'
     *
     * 是否被录用返回列表信息（多表综合）
     * @param ssno
     * @return
     */
    @Override
    public List<IfEmployedList> ifEmployedList(String ssno,String ps_state) {
        List<IfEmployedList> list = new ArrayList<IfEmployedList>();

        String sql = new String();
        if(ps_state == null || "".equals(ps_state)){
            sql = "select * from projectstatus where sno = ?";
        }
        else if("0".equals(ps_state)){
            sql = "select * from projectstatus where sno = ? and state = '0'";
        }
        else if("1".equals(ps_state)){
            sql = "select * from projectstatus where sno = ? and state = '1'";
        }
        else if("2".equals(ps_state)){
            sql = "select * from projectstatus where sno = ? and state = '2'";
        }
        else if("3".equals(ps_state)){
            sql = "select * from projectstatus where sno = ? and state = '3'";
        }

        List<ProjectStateAllInfo> state = template.query(sql, new BeanPropertyRowMapper<ProjectStateAllInfo>(ProjectStateAllInfo.class), ssno);
        for (ProjectStateAllInfo projectStateAllInfo : state) {
            IfEmployedList ifEmployedList = new IfEmployedList();
            //1
            int id = projectStateAllInfo.getId();
//            int pid = projectStateAllInfo.getPid();//下面有
            String pname = projectStateAllInfo.getPname();
            String pstate = projectStateAllInfo.getState();
            Date submitTime = projectStateAllInfo.getSubmitTime();

            //2
            String sql2 = "select * from projects where id = ?";//id = 状态表的pid
            int pid = projectStateAllInfo.getPid();
            ProjectAllInfo projectAllInfo = template.queryForObject(sql2,new BeanPropertyRowMapper<ProjectAllInfo>(ProjectAllInfo.class),pid);
            //3
            String sql3 = "select * from enterprises where ename= ?";
            String company = projectStateAllInfo.getCompany();
            EnterpriseAllInfo enterpriseAllInfo = template.queryForObject(sql3,new BeanPropertyRowMapper<EnterpriseAllInfo>(EnterpriseAllInfo.class),company);
            //4
            ifEmployedList.setId(id);//状态id，这里其实可以不返回，后面应该用不到，但对象封装了就弄一下
            ifEmployedList.setPid(pid);
            ifEmployedList.setPname(pname);
            ifEmployedList.setState(pstate);
            ifEmployedList.setPublishtime(projectAllInfo.getPublishtime());
            ifEmployedList.setSubmitTime(submitTime);
            System.out.println(submitTime);
            ifEmployedList.setEnterpriseAllInfo(enterpriseAllInfo);
            String sql4_count = "select count(*) from file where ps_id= ?";
            int cnt =  template.queryForObject(sql4_count, Integer.class, id);
            if(cnt > 0){
                String sql4 = "select * from file where ps_id= ?";
                FileSubmit fileSubmit =  template.queryForObject(sql4,new BeanPropertyRowMapper<FileSubmit>(FileSubmit.class),id);
                if(fileSubmit != null) ifEmployedList.setFileSubmit(fileSubmit);
            }
            list.add(ifEmployedList);
        }

        return list;
    }

    /**
     * 根据学号判断是否有简历了，不然不给提交简历
     * @param sno
     * @return
     */
    @Override
    public StuResumes returnResumeBySno(String sno) {
        try {
            String sql = "select * from resumes where rsno = ? ";
            StuResumes stuResumes = template.queryForObject(sql, new BeanPropertyRowMapper<StuResumes>(StuResumes.class),sno );
            return stuResumes;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public int submitProject_changeState(String id, String discriWord, Date date) {
//        System.out.println(discriWord);
        String sql = "update projectstatus set state = ?,discription = ?,submitTime = ? where id = ?";
        int count = template.update(sql,"3",discriWord,date, id);
        return count;
    }

    @Override
    public int submitProject_insertFilePath(int ps_id, String filepath, String filename) {
        String sql_ = "select count(id) from file where ps_id = ? ";
        Long total = template.queryForObject(sql_, Long.class, filepath);
//        System.out.println(total);
        if (total > 0) {
            return 0;
        }
        String sql = "insert into file(id,ps_id,file_path,file_name) " +
                "values(NULL,?,?,?)";
        int count = template.update(sql,ps_id,filepath,filename);
        return count;
    }
}

