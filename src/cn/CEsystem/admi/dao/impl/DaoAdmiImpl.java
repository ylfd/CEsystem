package cn.CEsystem.admi.dao.impl;

import cn.CEsystem.admi.dao.DaoAdmi;
import cn.CEsystem.admi.domain.AdmiAllInfo;
import cn.CEsystem.admi.util.JDBCUtils;
import cn.CEsystem.enterprise.domain.EnterpriseAllInfo;
import cn.CEsystem.student.domain.ProjectAllInfo;
import cn.CEsystem.student.domain.StudentAllInfo;
import cn.CEsystem.teacher.domain.TeacherAllInfo;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DaoAdmiImpl implements DaoAdmi {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public int register_admi(AdmiAllInfo admiAllInfo) {
        String sql_ = "select count(aid) from administrators where anumber = ?";
        Long total = template.queryForObject(sql_, Long.class,admiAllInfo.getAnumber());
        if(total>0){
            return 0;
        }
        String sql = "insert into administrators(aid,aname,anumber,apassword) " +
                "values(NULL,?,?,?)";
        int count = template.update(sql,admiAllInfo.getAname(),admiAllInfo.getAnumber(),admiAllInfo.getApassword());
        return count;
    }

    @Override
    public int countTotal_ExamineProject(Map<String, String[]> condition) {
        String sql = "select count(*) from projects where 1 = 1 ";
        StringBuilder sb = new StringBuilder(sql);
        //2.遍历map
        Set<String> keySet = condition.keySet();
        //定义参数的集合
        List<Object> params = new ArrayList<Object>();
        for (String key : keySet) {
            //排除分页条件参数
            if("currentPage".equals(key) || "rows".equals(key)){
                continue;
            }
            //获取value
            String value = condition.get(key)[0];
            //判断value是否有值
            if(value != null && !"".equals(value)){
                //处理datatime查询
                if("publishtime".equals(key)){
                    sb.append(" and convert("+key+",DATETIME) like ?");
                    params.add("%"+value+"%");
                    continue;
                }
                //有值
                sb.append(" and "+key+" like ? ");
                params.add("%"+value+"%");//？条件的值
            }
        }
        //查询审核通过的
//        sb.append(" and state = ?");
//        params.add("1");
        return template.queryForObject(sb.toString(),Integer.class,params.toArray());
    }

    @Override
    public List<ProjectAllInfo> findExamineProByPage(int start, int rows, Map<String, String[]> condition) {
        String sql = "select * from projects where 1 = 1 ";
        StringBuilder sb = new StringBuilder(sql);
        //2.遍历map
        Set<String> keySet = condition.keySet();
        //定义参数的集合
        List<Object> params = new ArrayList<Object>();
        for (String key : keySet) {
            //排除分页条件参数
            if("currentPage".equals(key) || "rows".equals(key)){
                continue;
            }
            //获取value
            String value = condition.get(key)[0];
            //判断value是否有值
            if(value != null && !"".equals(value)){
                //处理datatime查询
                if("publishtime".equals(key)){
                    sb.append(" and convert("+key+",DATETIME) like ?");
                    params.add("%"+value+"%");
                    continue;
                }
                //有值
                sb.append(" and "+key+" like ? ");
                params.add("%"+value+"%");//？条件的值
            }
        }
//        //查询审核通过的
//        sb.append(" and state = ?");
//        params.add("1");
        //添加分页查询
        sb.append(" ORDER BY publishtime desc limit ?,? ");
        //添加分页查询参数值
        params.add(start);
        params.add(rows);
        System.out.println(sb.toString());

        return template.query(sb.toString(),new BeanPropertyRowMapper<ProjectAllInfo>(ProjectAllInfo.class),params.toArray());
    }

    @Override
    public ProjectAllInfo retuenProjectByID(String id) {
        String sql = "select * from projects where id = ?";
        return template.queryForObject(sql, new BeanPropertyRowMapper<ProjectAllInfo>(ProjectAllInfo.class),id);
    }

    /**
     * 项目装填
     * state =1 通过
     * state = 0 等待审核
     * state = 2 管理员拒绝
     * @param id
     */
    @Override
    public void oneProject_YesNo(String id) {
        String sql = "update projects set state = '1' where id = ?";
        System.out.println(sql);
        template.update(sql,id);
    }

    @Override
    public void disagreeProject(String id) {
        String sql = "update projects set state = '2' where id = ?";
        template.update(sql,id);
    }

    @Override
    public int countTotal_Stu(Map<String, String[]> condition) {
        String sql = "select count(*) from students where 1 = 1 ";
        StringBuilder sb = new StringBuilder(sql);
        //2.遍历map
        Set<String> keySet = condition.keySet();
        //定义参数的集合
        List<Object> params = new ArrayList<Object>();
        for (String key : keySet) {
            //排除分页条件参数
            if("currentPage".equals(key) || "rows".equals(key)){
                continue;
            }
            //获取value
            String value = condition.get(key)[0];
            //判断value是否有值
            if(value != null && !"".equals(value)){
                //有值
                sb.append(" and "+key+" like ? ");
                params.add("%"+value+"%");//？条件的值
            }
        }
        return template.queryForObject(sb.toString(),Integer.class,params.toArray());
    }

    @Override
    public List<StudentAllInfo> findStuByPage(int start, int rows, Map<String, String[]> condition) {
        String sql = "select * from students where 1 = 1 ";
        StringBuilder sb = new StringBuilder(sql);
        //2.遍历map
        Set<String> keySet = condition.keySet();
        //定义参数的集合
        List<Object> params = new ArrayList<Object>();
        for (String key : keySet) {
            //排除分页条件参数
            if("currentPage".equals(key) || "rows".equals(key)){
                continue;
            }
            //获取value
            String value = condition.get(key)[0];
            //判断value是否有值
            if(value != null && !"".equals(value)){
                //有值
                sb.append(" and "+key+" like ? ");
                params.add("%"+value+"%");//？条件的值
            }
        }
        //添加分页查询
        sb.append(" limit ?,? ");
        //添加分页查询参数值
        params.add(start);
        params.add(rows);
        System.out.println(sb.toString());

        return template.query(sb.toString(),new BeanPropertyRowMapper<StudentAllInfo>(StudentAllInfo.class),params.toArray());
    }

    @Override
    public void deleteOneStudent(int sid) {
        //1.定义sql
        String sql = "delete from students where sid = ?";
        //2.执行sql
        template.update(sql, sid);
    }

    @Override
    public StudentAllInfo returnStuInfoBySid(int sid) {
        String sql = "select * from students where sid = ?";
        return template.queryForObject(sql, new BeanPropertyRowMapper<StudentAllInfo>(StudentAllInfo.class), sid);
    }

    @Override
    public void updateStuUser(StudentAllInfo s) {
        String sql = "update students set sname = ?,snumber = ? ,spassword = ? , ssex = ? ,snation = ?, sschool = ?, " +
                "scollege = ? , smajor = ? ,sphone = ? where sid = ?";
        template.update(sql, s.getSname(),s.getSnumber(),s.getSpassword(),s.getSsex(),s.getSnation(),
                s.getSschool(),s.getScollege(),s.getSmajor(),s.getSphone(),s.getSid());
    }

    @Override
    public int countTotal_Enterprise(Map<String, String[]> condition) {
        String sql = "select count(*) from enterprises where 1 = 1 ";
        StringBuilder sb = new StringBuilder(sql);
        //2.遍历map
        Set<String> keySet = condition.keySet();
        //定义参数的集合
        List<Object> params = new ArrayList<Object>();
        for (String key : keySet) {
            //排除分页条件参数
            if("currentPage".equals(key) || "rows".equals(key)){
                continue;
            }
            //获取value
            String value = condition.get(key)[0];
            //判断value是否有值
            if(value != null && !"".equals(value)){
                //有值
                sb.append(" and "+key+" like ? ");
                params.add("%"+value+"%");//？条件的值
            }
        }
        return template.queryForObject(sb.toString(),Integer.class,params.toArray());
    }

    @Override
    public List<EnterpriseAllInfo> findEnterpriseByPage(int start, int rows, Map<String, String[]> condition) {
        String sql = "select * from enterprises where 1 = 1 ";
        StringBuilder sb = new StringBuilder(sql);
        //2.遍历map
        Set<String> keySet = condition.keySet();
        //定义参数的集合
        List<Object> params = new ArrayList<Object>();
        for (String key : keySet) {
            //排除分页条件参数
            if("currentPage".equals(key) || "rows".equals(key)){
                continue;
            }
            //获取value
            String value = condition.get(key)[0];
            //判断value是否有值
            if(value != null && !"".equals(value)){
                //有值
                sb.append(" and "+key+" like ? ");
                params.add("%"+value+"%");//？条件的值
            }
        }
        //添加分页查询
        sb.append(" limit ?,? ");
        //添加分页查询参数值
        params.add(start);
        params.add(rows);
        System.out.println(sb.toString());

        return template.query(sb.toString(),new BeanPropertyRowMapper<EnterpriseAllInfo>(EnterpriseAllInfo.class),params.toArray());
    }

    @Override
    public void deleteOneEnterprise(String eid) {
        //1.定义sql
        String sql = "delete from enterprises where eid = ?";
        //2.执行sql
        template.update(sql, eid);
    }

    @Override
    public EnterpriseAllInfo returnEnterpriseInfoBySid(String eid) {
        String sql = "select * from enterprises where eid = ?";
        return template.queryForObject(sql, new BeanPropertyRowMapper<EnterpriseAllInfo>(EnterpriseAllInfo.class), eid);
    }

    @Override
    public void updateEnterpriseUser(EnterpriseAllInfo e) {
        String sql = "update enterprises set enumber = ?, epassword = ?, eintroduce = ?, eaddress = ?, ephone = ? where eid = ?";
        template.update(sql, e.getEnumber(),e.getEpassword(),e.getEintroduce(),e.getEaddress(),e.getEphone(),e.getEid());
    }

    @Override
    public int countTotal_Teacher(Map<String, String[]> condition) {
        String sql = "select count(*) from teachers where 1 = 1 ";
        StringBuilder sb = new StringBuilder(sql);
        //2.遍历map
        Set<String> keySet = condition.keySet();
        //定义参数的集合
        List<Object> params = new ArrayList<Object>();
        for (String key : keySet) {
            //排除分页条件参数
            if("currentPage".equals(key) || "rows".equals(key)){
                continue;
            }
            //获取value
            String value = condition.get(key)[0];
            //判断value是否有值
            if(value != null && !"".equals(value)){
                //有值
                sb.append(" and "+key+" like ? ");
                params.add("%"+value+"%");//？条件的值
            }
        }
        return template.queryForObject(sb.toString(),Integer.class,params.toArray());
    }

    @Override
    public List<TeacherAllInfo> findTeacherByPage(int start, int rows, Map<String, String[]> condition) {
        String sql = "select * from teachers where 1 = 1 ";
        StringBuilder sb = new StringBuilder(sql);
        //2.遍历map
        Set<String> keySet = condition.keySet();
        //定义参数的集合
        List<Object> params = new ArrayList<Object>();
        for (String key : keySet) {
            //排除分页条件参数
            if("currentPage".equals(key) || "rows".equals(key)){
                continue;
            }
            //获取value
            String value = condition.get(key)[0];
            //判断value是否有值
            if(value != null && !"".equals(value)){
                //有值
                sb.append(" and "+key+" like ? ");
                params.add("%"+value+"%");//？条件的值
            }
        }
        //添加分页查询
        sb.append(" limit ?,? ");
        //添加分页查询参数值
        params.add(start);
        params.add(rows);
//        System.out.println(sb.toString());

        return template.query(sb.toString(),new BeanPropertyRowMapper<TeacherAllInfo>(TeacherAllInfo.class),params.toArray());
    }

    @Override
    public void deleteOneTeacher(int tid) {
        //1.定义sql
        String sql = "delete from teachers where tid = ?";
        //2.执行sql
        template.update(sql, tid);
    }

    @Override
    public TeacherAllInfo returnTeacherInfoBySid(int tid) {
        String sql = "select * from teachers where tid = ?";
        return template.queryForObject(sql, new BeanPropertyRowMapper<TeacherAllInfo>(TeacherAllInfo.class), tid);
    }

    @Override
    public void updateTeacherUser(TeacherAllInfo t) {
        String sql = "update teachers set tname = ?, tnumber = ?, tpassword = ?, tschool = ?, tcollege = ?," +
                "tsex = ?,ttitle = ?,tphone = ? where tid = ?";
        template.update(sql,t.getTname(),t.getTnumber(),t.getTpassword(),t.getTschool(),t.getTcollege(),t.getTsex(),t.getTtitle(),t.getTphone(),t.getTid());
    }
}
