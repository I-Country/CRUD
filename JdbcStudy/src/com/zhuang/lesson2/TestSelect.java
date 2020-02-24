package com.zhuang.lesson2;

import com.zhuang.lesson2.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestSelect {
    public static void main(String[] args){
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs =null;

       try{
           conn = JdbcUtils.getConnection();

           String sql = "select * from users where id =?";

           st = conn.prepareStatement(sql);

           st.setInt(1,4);

           rs = st.executeQuery();

           if (rs.next()){
               System.out.println(rs.getString("name"));
           }
       } catch (SQLException e) {
           e.printStackTrace();
       }finally {
           JdbcUtils.release(conn,st,rs);
       }
    }
}
