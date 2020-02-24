package com.zhuang.lesson2;

import com.zhuang.lesson2.utils.JdbcUtils;

import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestInsert {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement st = null;

        try {
            conn = JdbcUtils.getConnection();
            //使用？占位符代替参数
            String sql = "insert into users(id,`name`,`password`,`email`,`birthday`)values(?,?,?,?,?)";

            st = conn.prepareStatement(sql);

            //手动给参数赋值
            st.setInt(1, 4);
            st.setString(2,"大表哥");
            st.setString(3,"123456");
            st.setString(4,"123123@qq.com");

            //import java.util.Date;使用java日期格式
            st.setDate(5,new java.sql.Date(new Date().getTime()));

            //执行
            int i = st.executeUpdate();
            if (i>0){
                System.out.println("插入成功");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.release(conn,st,null);
        }

    }

}

