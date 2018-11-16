package com.pudge.demo.service;


import com.pudge.demo.entity.Student;

/**
 * @author liuhu
 */
public class StudentService {
    public void batchInsert() {
        System.out.println("开始录入学生信息");
        for(int i = 0;i < 100 ;i++){
            createStudent(i);
            System.out.println("录入 张三"+i+"号 ing...");
        }
        System.out.println("开始录入学生信息");

    }

    /**
     * 创建单个学生
     * @return Student
     */
    private Student createStudent(int i){
        Student student = new Student();
        student.setName("张三"+i+"号");
        student.setAge(15+i%2);
        student.setClassNum(6+i%3);
        return student;
    }
}
