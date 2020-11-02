package com.starcpdk.mapper;

import com.starcpdk.pojo.Student;
import com.starcpdk.pojo.Teacher;
import com.starcpdk.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class MyTest {
    @Test
    public void testStudent() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> students = mapper.getStudent2();

        for (Student student : students) {
            System.out.println(student);
        }

        sqlSession.close();
    }
}
