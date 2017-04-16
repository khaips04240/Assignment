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
import poly.bean.Depart;

/**
 *
 * @author Administrator
 */
public class DepartModel {
    public  DepartModel(){
    }
     public static List<Depart> showDeparts(String tenpb){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url="jdbc:sqlserver://localhost:1433;databaseName=ASM";
            Connection con = DriverManager.getConnection(url, "sa", "123");
            String sql = "select * from Departs";
            if(tenpb.length() > 0){
                sql += " where Id like '%"+tenpb+"%'";
            }
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            List<Depart> list = new ArrayList<Depart>();
            while(rs.next()){
                String id = rs.getString("Id");
                String name = rs.getString("Name");
                Depart dp = new Depart(id,name);
                list.add(dp);
            }
            return list;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public static void deleteDeparts(String id){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url="jdbc:sqlserver://localhost:1433;databaseName=ASM";
            Connection con = DriverManager.getConnection(url, "sa", "123");
            String sql = "delete from Departs where Id=?";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, id);
            stm.executeUpdate();
            stm.close();
            con.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void insert(Depart depart){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url="jdbc:sqlserver://localhost:1433;databaseName=ASM";
            Connection con = DriverManager.getConnection(url, "sa", "123");
            String sql = "insert into Departs values(?,?)";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, depart.getid());
            stm.setString(2, depart.getname());
            stm.executeUpdate();
            stm.close();
            con.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void update(Depart depart){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url="jdbc:sqlserver://localhost:1433;databaseName=ASM";
            Connection con = DriverManager.getConnection(url, "sa", "123");
            String sql = "update Departs set  Name=? where Id=?";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, depart.getname());
            stm.setString(2, depart.getid());
            stm.executeUpdate();
            stm.close();
            con.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

}
