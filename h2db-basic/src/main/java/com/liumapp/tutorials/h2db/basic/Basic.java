package com.liumapp.tutorials.h2db.basic;

import org.apache.commons.io.FileUtils;

import java.io.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * file Basic.java
 * author liumapp
 * github https://github.com/liumapp
 * email liumapp.com@gmail.com
 * homepage http://www.liumapp.com
 * date 2019/6/17
 */
public class Basic
{
    /**
     * 执行后会在./data/db目录下生成一个名为test_basic.mv.db和test_basic.trace.db文件，存放数据库文件
     * @param args
     */
    public static void main( String[] args ) {
        String JDBC_DRIVER = "org.h2.Driver";
        String url = "jdbc:h2:./data/db/test_basic"; // persisted database 将数据保存在磁盘中，重启后依然存在
//        String url = "jdbc:h2:mem:test_basic"; // in-memory database 将数据保存在内存中，重启后将会丢失
        String user = "sa";
        String passwd = "";
        String query = "SELECT * FROM cars";

        try {
            //注册JDBC驱动类
            Class.forName(JDBC_DRIVER);
            //建立链接
            Connection conn = DriverManager.getConnection(url, user, passwd);
            Statement st = conn.createStatement();
            //检查scheme是否存在，表名必须大写
            if (!checkTable(conn, "CARS")) {
                //不存在的话创建
                initTable(st);
            }
            //查询cars这张表的数据
            ResultSet rs = selectTable(st, query);
            while (rs.next()) {
                System.out.printf("%d %s %d%n", rs.getInt(1),
                        rs.getString(2), rs.getInt(3));
            }
            st.close();
            conn.close();
        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(Basic.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static boolean checkTable (Connection conn, String tableName) throws SQLException {
        ResultSet rset = conn.getMetaData().getTables(null, null, tableName, null);
        if (rset.next())
        {
            System.out.println("we found table named:" + tableName);
            return true;
        }
        System.out.println("we do not found table named:" + tableName);
        return false;
    }

    public static void initTable (Statement st) throws SQLException, IOException {
        File file = new File(Basic.class.getClassLoader().getResource("./cars.sql").getPath());
        String sql = FileUtils.readFileToString(file);
        st.executeUpdate(sql);
    }

    public static ResultSet selectTable (Statement st, String query) throws SQLException {
        ResultSet rs = st.executeQuery(query);
        return rs;
    }
}
