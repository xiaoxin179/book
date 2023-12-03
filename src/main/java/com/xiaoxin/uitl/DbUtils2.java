package com.xiaoxin.uitl;

import java.sql.*;

/**
 * @author:XIAOXIN
 * @date:2023/11/25
 **/
public class DbUtils2 {
    public static Connection getConn() {

        Connection conn=null;
        try { //1加载驱动
            Class.forName("com.mysql.cj.jdbc.Driver"); // 1
            //System.out.println("鍔犺浇鎴愬姛");
        }
        catch (ClassNotFoundException e)
        {e.printStackTrace();
        }

        //2链接到数据库
        String url = "jdbc:mysql://60.204.188.249:3306/bookmanagement?useUnicode=true&serverTimezone=UTC&characterEncoding=utf8";
        String databaseUserName = "webuser";
        String databasePassWord = "DGYdgy130062";
        try {
            conn = DriverManager.getConnection(url, databaseUserName, databasePassWord);//2
            System.out.println("数据库连接成功！！！");
        }
        catch (SQLException e)
        {e.printStackTrace();}
        return conn;
    }


    //鍏抽棴閾炬帴
    public static void closeConn(Connection conn) {
        try {
            if(conn!=null) {
                conn.close();
                conn=null;
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static PreparedStatement getPreStmt(Connection conn, String sql) {
        PreparedStatement PreStmt=null;
        try {
            PreStmt=conn.prepareStatement(sql);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return PreStmt;
    }

    public static void closeStmt(PreparedStatement pstmt) {
        try {
            if(pstmt!=null) {
                pstmt.close();
                pstmt=null;
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void closeResultSet(ResultSet rs) {
        try {
            if(rs!=null) {
                rs.close();
                rs=null;
            }
        }catch(SQLException e) {
            e.printStackTrace();
        }
    }

}
