package com.joyowo.exchange.jdbc;

import com.joyowo.exchange.utils.DataBase;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcHandler {
    /**
     * 查找未支付完的订单信息
     *
     * @return
     */
    public void findTransInfo(String sql) throws Exception {

        java.sql.Connection con = null;
        Statement stmt = null;
        try {
            Class.forName(DataBase.getDriver2());
            String url = DataBase.getUrl2();
            String username = DataBase.getUsername2();
            String password = DataBase.getPassword2();
            con = DriverManager.getConnection(url, username, password);
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
            }
            if (rs != null) {
                rs.close();
            }
        } catch (Exception e) {
            System.out.println("数据库连接失败！");
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
    public boolean updateBySql(String sql) throws Exception {
        java.sql.Connection con = null;
        Statement stmt = null;
        try {
            Class.forName(DataBase.getDriver());
            String url = DataBase.getUrl();
            String username = DataBase.getUsername();
            String password = DataBase.getPassword();
            con = DriverManager.getConnection(url, username, password);
            stmt = con.createStatement();
            return 1 == stmt.executeUpdate(sql);
        } catch (Exception e) {
            System.out.println("数据库连接失败！");
            e.printStackTrace();
            throw e;
        } finally {
            closeJdbc(con, stmt);
        }
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
