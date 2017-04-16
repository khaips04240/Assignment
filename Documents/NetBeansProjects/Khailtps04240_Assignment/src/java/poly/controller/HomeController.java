package poly.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
        @RequestMapping("/login")
        public String login(){
            return "login";
        }
        @RequestMapping("/error")
        public String error(){
            return "error";
        }
         @RequestMapping("/nhanvien")
        public String nhanvien(){
            return "nhanvien";
        }
          @RequestMapping("/phongban")
        public String phongban(){
            return "phongban";
        }
	@RequestMapping("/home/index")
	public String index() {
		return "home/index";
	}

	@RequestMapping("/home/ttkl")
	public String ttkl() {
		return "home/ttkl";
	}
	@RequestMapping("/home/tonghop")
	public String tonghop() {
		return "home/tonghop";
	}
        @RequestMapping("/home/gmxs")
	public String gmxs() {
		return "home/gmxs";
	}
}
