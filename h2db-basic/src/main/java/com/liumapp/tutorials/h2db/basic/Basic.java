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
        String url = "jdbc:h2:./data/db/test_basic";
        String user = "sa";
        String passwd = "";
        String query = "SELECT * FROM cars";

        try {
            Class.forName(JDBC_DRIVER);
            File file = new File(Basic.class.getClassLoader().getResource("./cars.sql").getPath());
            String sql = FileUtils.readFileToString(file);

            Connection con = DriverManager.getConnection(url, user, passwd);
            Statement st = con.createStatement();
            //第一次执行查询之前，先插入sql生成scheme跟一些数据
            if (!new File("./data/db/test_basic.mv.db").exists()) {
                st.executeUpdate(sql);
            }
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                System.out.printf("%d %s %d%n", rs.getInt(1),
                        rs.getString(2), rs.getInt(3));
            }

        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(Basic.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
