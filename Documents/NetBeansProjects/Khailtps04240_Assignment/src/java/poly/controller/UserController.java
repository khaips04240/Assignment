package poly.controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import poly.bean.User;
import poly.model.Usermodel;

/**
 *
 * @author Administrator
 */
@Controller
public class UserController {
    @RequestMapping("showall")
    public String showAll(ModelMap model){
        Usermodel usm = new Usermodel();
        List<User> list = new ArrayList<User>();
        list = usm.showUser("");
        model.addAttribute("listUser", list); 
        User user = new User();
  
        model.addAttribute("user", user);
        return "quanlytk";
    }
    
    @RequestMapping("/edit")
    public String edit(HttpServletRequest request, ModelMap model){
       String username = request.getParameter("txtUsername");
        String password = request.getParameter("txtPassword");
        String fullname = request.getParameter("txtFullname");
        User user = new User(username, password, fullname);
        model.addAttribute("user", user);
        
        List<User> list = new ArrayList<User>();
        list = Usermodel.showUser("");
        model.addAttribute("listUser", list);
        return "quanlytk";
    }       
    @RequestMapping("/delete")
    public String delete(HttpServletRequest request, ModelMap model, 
            @ModelAttribute("user") User user){
        String username = request.getParameter("txtUsername");
        Usermodel.delete(username);
        List<User> list = new ArrayList<User>();
        list = Usermodel.showUser("");
        model.addAttribute("listUser", list);
        return "quanlytk";
    }
    @RequestMapping(params="btnUpdate")
    public String update(@ModelAttribute("user") User us, ModelMap model) {       
        Usermodel.update(us);
        List<User> list = new ArrayList<User>();
        list = Usermodel.showUser("");
        model.addAttribute("listUser", list);
        return "quanlytk";
    }   
    @RequestMapping(params="btnInsert")
    public String insert(@ModelAttribute("user") User user, ModelMap model){
        Usermodel.insert(user);
        List<User> list = new ArrayList<User>();
        list = Usermodel.showUser("");
        model.addAttribute("listUser", list);
        return "quanlytk";
    }
}
