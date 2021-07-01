package com.canteen.CMS.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class Home {

    @GetMapping(path = "/")
    public String home() {

        return "index";
    }

    @GetMapping(path = "login")
    public String login() {

        return "login";
    }

    @GetMapping(path = "register")
    public String register() {

        return "register";
    }





}
