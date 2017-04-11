/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Khachhang;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import util.HibernateUtil;

/**
 *
 * @author Administrator
 */
public class KhachhangDAO {
     public static List<Khachhang> layDanhSachKH(String tenkh){
        List<Khachhang> list = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        String sql = "from Khachhang";
        if(tenkh.length()>0){
            sql += " kh where kh.hoVaTen like '%"+tenkh+"%'";
        }
        Query query = session.createQuery(sql);
        list = query.list();
        return list;
    }
    public KhachhangDAO(){
    }
    public static boolean xoaKhachHang(String maKhachHang){
        Khachhang kh = KhachhangDAO.layThongTinKH(maKhachHang);
        if(kh == null)
            return false;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try{
            session.getTransaction().begin();
            session.delete(kh);
            session.getTransaction().commit();
            return true;
        }catch(Exception e){
            session.getTransaction().rollback();
            System.out.print(e);
            return false;
        }
    }
    public static Khachhang layThongTinKH(String makh){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Khachhang kh = (Khachhang) session.get(Khachhang.class,makh);
        session.close();
        return kh;
    }
    public static void themKhachhang(Khachhang kh){
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
           session.beginTransaction();
           session.save(kh);
           session.getTransaction().commit();
           
        }catch(Exception e){
            session.getTransaction().rollback();
            System.out.println(e);
           
       }
         
    }
    public static boolean capNhatThongTinKhachHang(Khachhang kh){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try{
            session.beginTransaction();
            session.update(kh);
            session.getTransaction().commit();
            session.close();
           return true;
        }catch(Exception e){
            session.getTransaction().rollback();
            System.out.print(e);
            return false;
        }
    }
   
}

    

