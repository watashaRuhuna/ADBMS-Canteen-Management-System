package com.canteen.CMS.Controller;

import com.canteen.CMS.Services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class User {
    @Autowired
    private OrderService orderService;

    @GetMapping(path = "/userhistory")
    public String userHistory(Model model,HttpSession session) {

        List<String> users= (List<String>) session.getAttribute("ÜSER_SESSION");
        Integer id=Integer.parseInt(users.get(0));

        model.addAttribute("orders",orderService.order_history(id));
        return "user/user_history";
    }

    @RequestMapping(path = "/order_cancel",method = RequestMethod.POST)
    public String order_cancel(@RequestParam("orderId")Integer order_id){

        orderService.OrderCancel(order_id);
        return "redirect:/userhistory";
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
