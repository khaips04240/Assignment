/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poly.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import poly.bean.User;

/**
 *
 * @author Administrator
 */
public class Usermodel {
    
     public Usermodel() {
         
     }
 
    public static List<User> showUser(String user){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url="jdbc:sqlserver://localhost:1433;databaseName=ASM";
            Connection con = DriverManager.getConnection(url, "sa", "123");
            String sql = "select * from Users";
            if(user.length() > 0){
                sql += " where Username like '%"+user+"%'";
            }
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            List<User> list = new ArrayList<User>();
            while(rs.next()){
                String username = rs.getString("Username");
                String password = rs.getString("Password");
                String fullname = rs.getString("Fullname");
                User us = new User(username, password, fullname);
                list.add(us);
            }
            return list;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public static void delete(String username){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url="jdbc:sqlserver://localhost:1433;databaseName=ASM";
            Connection con = DriverManager.getConnection(url, "sa", "123");
            String sql = "delete from Users where Username=?";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, username);
            stm.executeUpdate();
            stm.close();
            con.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void insert(User user){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url="jdbc:sqlserver://localhost:1433;databaseName=ASM";
            Connection con = DriverManager.getConnection(url, "sa", "123");
            String sql = "insert into Users values(?,?,?)";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, user.getusername());
            stm.setString(2, user.getpassword());
            stm.setString(3, user.getfullname());
            stm.executeUpdate();
            stm.close();
            con.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void update(User user){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url="jdbc:sqlserver://localhost:1433;databaseName=ASM";
            Connection con = DriverManager.getConnection(url, "sa", "123");
            String sql = "update Users set  Password=?, Fullname=? where Username=?";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, user.getpassword());
            stm.setString(2, user.getfullname());
            stm.setString(3, user.getusername());
            stm.executeUpdate();
            stm.close();
            con.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

}
