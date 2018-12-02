package com.pudge.demo;


import com.pudge.demo.service.StudentService;

/**
 * @author liuhu
 */
public class MainThread {
    private static StudentService studentService;

    public static void main(String[] arg) {
        studentService = new StudentService();
        initData();
        statistics();
        //测试代码冲突，分支注释
    }


    /**
     * 数据初始化
     */
    private static void initData() {
        //清除历史数据
        studentService.clean();
        //新建学员信息
        studentService.batchInsert();
    }

    /**
     * 统计--数据分析
     */
    private static void statistics() {
        //取出各个科目成绩最高的人
        //分支的代码
    }
}


