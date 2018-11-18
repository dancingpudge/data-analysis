package com.pudge.demo.service;


import com.pudge.demo.dao.StudentDao;
import com.pudge.demo.entity.Student;

/**
 * @author liuhu
 */
public class StudentService {

    private final StudentDao studentDao;

    public StudentService() {
        this.studentDao = new StudentDao();
    }

    public void batchInsert() {
        System.out.println("开始录入学生信息");
        for (int i = 0; i < 10; i++) {
            Student student = createStudent(i);
            System.out.println("录入 张三" + i + "号 ing...");
            studentDao.insertStudent(student);
        }
        System.out.println("结束录入学生信息");

    }

    /**
     * 创建单个学生
     *
     * @return Student
     */
    private Student createStudent(int i) {
        Student student = new Student();
        student.setName(i + "号");
        student.setAge(15 + i % 2);
        student.setClassNum(6 + i % 3);
        student.setChinese(50 * Math.random() + 40);
        student.setMath(50 * Math.random() + 40);
        student.setEnglish(50 * Math.random() + 40);
        student.setPhysics(50 * Math.random() + 40);
        return student;
    }
}
