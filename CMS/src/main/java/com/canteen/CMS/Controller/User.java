package com.canteen.CMS.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class User {
    @GetMapping(path = "/userhistory")
    public String userHistory() {

        return "user/user_history";
    }
   /* @GetMapping(path = "/profile")
    public String profile(HttpSession session){
        List<String> users= (List<String>) session.getAttribute("ÜSER_SESSION");

        if(users==null){
            return "redirect:/login";
        }else{
            return "user/user_home";
        }*/
    //}


}
