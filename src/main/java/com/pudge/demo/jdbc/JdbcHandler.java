package com.pudge.demo.jdbc;

import com.pudge.demo.utils.DataBase;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author liuhu
 */
public class JdbcHandler {
    DataBase dataBase;

    public JdbcHandler() {
        this.dataBase = new DataBase();
    }

    /**
     * @return
     */
    public void findTransInfo(String sql) throws Exception {

        java.sql.Connection con = null;
        Statement stmt = null;
        try {
            Class.forName(dataBase.driver);
            con = DriverManager.getConnection(dataBase.url, dataBase.username, dataBase.password);
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
            }
            if (rs != null) {
                rs.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            closeJdbc(con, stmt);
        }
    }


    /**
     * 处理sql语句
     *
     * @return boolean
     */
    public boolean executeSql(String sql) {
        java.sql.Connection con = null;
        Statement stmt = null;
        try {
            System.out.println("正在执行的AQL ===>" + sql);
            con = DriverManager.getConnection(dataBase.url, dataBase.username, dataBase.password);
            stmt = con.createStatement();
            return stmt.execute(sql);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeJdbc(con, stmt);
        }
        return false;
    }

    /**
     * 关闭数据库连接
     *
     * @param con
     * @param stmt
     */
    private void closeJdbc(java.sql.Connection con, Statement stmt) {
        try {
            if (stmt != null) {
                stmt.close();
            }
            if (con != null) {
                con.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
