package com.canteen.CMS.Controller;
import com.canteen.CMS.Entity.AddNewFoodEntity;
import com.canteen.CMS.Entity.UserEntity;
import com.canteen.CMS.Services.FoodService;
import com.canteen.CMS.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Objects;

@Controller
public class Home {
    @Autowired
    private UserService userService;


    @GetMapping(path = "/")
    public String home() {

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

  @PostMapping("/login")
  @ResponseBody
    private void userLogin(@ModelAttribute("UserLoginController") UserEntity userEntity){


     userService.userLogin(userEntity.getUser_email(),userEntity.getUser_pwd());


//        if (Objects.nonNull(userlog)) {
//
//            return "redirect:/";
//        }
//        else {
//            return "redirect:/login";
//        }
//      return userlog;
    }

    @PostMapping("/AddNewUserService")
    private String addNewUser(@ModelAttribute("createUserController")UserEntity userEntity){

        //addNewFoodEntity.setCategory_type("asd");
        userService.addUser(userEntity);
        return "redirect:/login";
    }

}
