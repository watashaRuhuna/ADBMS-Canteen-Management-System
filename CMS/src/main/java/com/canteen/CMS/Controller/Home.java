package com.canteen.CMS.Controller;
import com.canteen.CMS.Entity.AddNewFoodEntity;
import com.canteen.CMS.Entity.OrderEntity;
import com.canteen.CMS.Entity.UserEntity;
import com.canteen.CMS.Services.FoodService;
import com.canteen.CMS.Services.OrderService;
import com.canteen.CMS.Services.UserService;
import org.hibernate.Session;
import org.hibernate.query.criteria.internal.expression.function.CurrentDateFunction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Controller
public class Home {
    @Autowired
    private UserService userService;
    @Autowired
    private FoodService foodService;

    @Autowired
    private OrderService orderService;

    @GetMapping(path = "/")
    public String home(Model model) {
        List<AddNewFoodEntity> addNewFoodEntities = foodService.getAllFood();
        OrderEntity addNewOrder = new OrderEntity();
        model.addAttribute("allfoodlist",addNewFoodEntities);
        model.addAttribute("confirmOrderObj",addNewOrder);
        return "index";
    }

    @GetMapping(path = "login")
    public String login(Model model) {
        UserEntity userLogin = new UserEntity();
        model.addAttribute("UserLoginController",userLogin);

        return "login";
    }

    @GetMapping(path = "register")
    public String register(Model model) {

        UserEntity createUser = new UserEntity();
        model.addAttribute("createUserController",createUser);
        return "register";
    }


  @PostMapping(path = "/login")
    public String userLogin(@ModelAttribute("UserLoginController") UserEntity userEntity, HttpServletRequest request){
     UserEntity loged_user= userService.userLogin(userEntity.getEmail(),userEntity.getPassword());

      List<String> users= (List<String>) request.getSession().getAttribute("??SER_SESSION");

        if(Objects.nonNull(loged_user)) {
            if(users==null){
                users=new ArrayList<>();
                request.getSession().setAttribute("??SER_SESSION",users);
            }
            users.add(loged_user.getUser_id().toString());
            users.add(loged_user.getUser_name());
            users.add(loged_user.getUser_mobile());
            users.add(loged_user.getUser_position());

            request.getSession().setAttribute("??SER_SESSION",users);

            return "redirect:/profile";
        }else {
            return "redirect:/login";
        }
    }

    @PostMapping("/AddNewUserService")
    private String addNewUser(@ModelAttribute("createUserController")UserEntity userEntity){

        userService.addUser(userEntity);
        return "redirect:/login";
    }

    @GetMapping(path = "/profile")
    public String profile(HttpSession session){
        List<String> users= (List<String>) session.getAttribute("??SER_SESSION");

        if(users==null){
            return "redirect:/login";
        }else{
            return "user/user_home";
        }
    }


    @PostMapping(path ="/confirmorderAction")
    private String confirmOrder(@ModelAttribute("confirmOrderObj")OrderEntity orderEntity, HttpSession session){

        List<String> ownerSessionid= (List<String>) session.getAttribute("??SER_SESSION");


        Date currentSqlDate = new Date(System.currentTimeMillis());
        orderEntity.setIs_cancel(0);
        orderEntity.setTotal_price(0);
        orderEntity.setIs_done(0);
        orderEntity.setUser_id(Integer.parseInt(ownerSessionid.get(0)));
        orderEntity.setOrder_date(currentSqlDate);
        System.out.println(orderEntity.getOrder_qty());
        orderService.addOrder(orderEntity);

        return "redirect:/";
    }
}
