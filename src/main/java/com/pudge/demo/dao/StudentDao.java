package com.pudge.demo.dao;

import com.pudge.demo.entity.Student;
import com.pudge.demo.jdbc.JdbcHandler;

/**
 * @author liuhu
 */
public class StudentDao {
    private final JdbcHandler handler;

    public StudentDao() {
        this.handler = new JdbcHandler();
    }

    public void insertStudent(Student student) {
        handler.executeSql(
                "INSERT INTO `student` ( `grade`, `name`, `age`, `classNum`, `chinese`, `math`, `english`, `physics`) " +
                        "VALUES ( " + student.getClassNum() + ", '" + student.getName() + "', " + student.getAge() + ", " + student.getClassNum() + ", " +
                        student.getChinese() + ", " + student.getMath() + ", " + student.getEnglish() + ", " + student.getPhysics()
                        + ");");
    }

    public void clean() {
        handler.executeSql("delete from student");
    }
}
