package com.canteen.CMS.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Owner {

    @GetMapping(path = "owner_home")
    public String home() {

        return "owner/index";
    }
    @GetMapping(path = "admin_login")
    public String ownerLogin() {

        return "owner/login";
    }
    @GetMapping(path = "addfood")
    public String addFood() {

        return "owner/pages/addfood";
    }
    @GetMapping(path = "breakfirst")
    public String breakfirst() {

        return "owner/pages/breakfirst";
    }
    @GetMapping(path = "dinner")
    public String dinner() {

        return "owner/pages/dinner";
    }
    @GetMapping(path = "emergency")
    public String emergency() {

        return "owner/pages/emergency";
    }
    @GetMapping(path = "inventory")
    public String inventory() {

        return "owner/pages/inventory";
    }
    @GetMapping(path = "lunch")
    public String lunch() {

        return "owner/pages/lunch";
    }
    /*<a class="nav-link" th:href="@{loginpage}">Login</a>*/

}
