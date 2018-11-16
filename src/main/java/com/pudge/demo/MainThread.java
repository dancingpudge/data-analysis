package com.pudge.demo;


import com.pudge.demo.service.StudentService;

/**
 * @author liuhu
 */
public class MainThread {
    public static void main(String[] arg) {
        initData();
        createStudents();
        statistics();
    }



    /**
     * 数据初始化
     */
    private static void initData() {
    }

    /**
     * 批量创建学生
     */
    private static void createStudents() {
     new StudentService().batchInsert();
    }

    /**
     * 统计--数据分析
     */
    private static void statistics() {
    }
}


