/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poly.controller;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import poly.bean.Depart;
import poly.model.DepartModel;




/**
 *
 * @author Administrator
 */
@Controller 
@RequestMapping("/phongban/")
public class DepartController {
     @RequestMapping("/showalldp")
    public String showDeparts(ModelMap model){
        DepartModel dpt = new DepartModel();
        List<Depart> list = new ArrayList<Depart>();
        list = dpt.showDeparts("");
        model.addAttribute("listDepart", list); 
        Depart depart = new Depart();
        model.addAttribute("depart", depart);
        return "phongban";
    }
    
    @RequestMapping("/edit")
    public String editDeparts(HttpServletRequest request, ModelMap model){
       String id = request.getParameter("txtId");
        String name = request.getParameter("txtName");
        Depart depart = new Depart(id, name);
        model.addAttribute("depart", depart);
        
        List<Depart> list = new ArrayList<Depart>();
        list = DepartModel.showDeparts("");
        model.addAttribute("listDepart", list);
        return "phongban";
    }       
    @RequestMapping("/delete")
    public String delete(HttpServletRequest request, ModelMap model, 
            @ModelAttribute("depart") Depart depart){
        String id = request.getParameter("txtId");
        DepartModel.deleteDeparts(id);
        List<Depart> list = new ArrayList<Depart>();
        list = DepartModel.showDeparts("");
        model.addAttribute("listDepart", list);
        return "phongban";
    }
    @RequestMapping(value = "/showalldp",params="btnUpdate2")
    public String update(@ModelAttribute("depart") Depart depart, ModelMap model) {       
        DepartModel.update(depart);
        List<Depart> list = new ArrayList<Depart>();
        list = DepartModel.showDeparts("");
        model.addAttribute("listDepart", list);
        return "phongban";
    }   
    @RequestMapping(value = "/showalldp",params="btnInsert2")
    public String insert(@ModelAttribute("depart") Depart depart, ModelMap model){
        DepartModel.insert(depart);
        List<Depart> list = new ArrayList<Depart>();
        list = DepartModel.showDeparts("");
        model.addAttribute("listDepart", list);
        return "phongban";
    }
}
