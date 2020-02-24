package com.zhuang.lesson2;

import com.zhuang.lesson2.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestUpdate {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement st = null;

        try {
            conn = JdbcUtils.getConnection();
            //使用？占位符代替参数
            String sql = "update users set `name`=? where id=? ;";

            st = conn.prepareStatement(sql);

            //手动给参数赋值
            st.setString(1,"大表哥");
            st.setInt(2,4);

            //import java.util.Date;使用java日期格式
//            st.setDate(5,new java.sql.Date(new Date().getTime()));

            //执行
            int i = st.executeUpdate();
            if (i>0){
                System.out.println("更新成功");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.release(conn,st,null);
        }

    }
}
