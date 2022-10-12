package cn.CEsystem.student.test;

import cn.CEsystem.student.dao.DaoStudent;
import cn.CEsystem.student.dao.impl.DaoStudentImpl;
import cn.CEsystem.student.domain.StudentAllInfo;
import cn.CEsystem.student.domain.User;
//import org.junit.Test;

public class TestLogin {
//    @Test
    public void testLogin() {
        User studentUser = new User();
        studentUser.setUsername("18111207294");
        studentUser.setPassword("123");
        DaoStudent daoStudent = new DaoStudentImpl();
        StudentAllInfo user = daoStudent.login(studentUser);
        System.out.println(user.toString());
        System.out.println(studentUser.toString());
    }
//    @Test
    public void testRegister() {
        StudentAllInfo studentAllInfo = new StudentAllInfo();
        studentAllInfo.setSname("马化腾1");
        studentAllInfo.setSnumber("18221");
        studentAllInfo.setSpassword("1231");
        studentAllInfo.setSsno("18111207261");
        System.out.println(studentAllInfo.toString());
        int count = new DaoStudentImpl().register_stu(studentAllInfo);
        System.out.println(count);
    }

}
