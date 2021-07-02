package com.canteen.CMS.Controller;

import com.canteen.CMS.Entity.AddNewFoodEntity;
import com.canteen.CMS.Entity.OwnerEntity;
import com.canteen.CMS.Services.FoodService;
import com.canteen.CMS.Services.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Controller
public class Owner {

    @Autowired
    private OwnerService ownerService;

    @Autowired
    private FoodService foodService;


    @GetMapping(path = "owner_home")
    public String home(Model model, HttpSession session) {

        List<String> ownerSession= (List<String>) session.getAttribute("ADMIN_SESSION");
        if(ownerSession==null){
            return "redirect:/";
        }else{

            model.addAttribute("food_count",foodService.getCount());
            return "owner/index";
        }




    }
    @GetMapping(path = "admin_login")
    public String ownerLogin(Model model) {
        OwnerEntity ownerlogin = new OwnerEntity();
        model.addAttribute("ownerLoginFromController",ownerlogin);
        return "owner/login";
    }
    @GetMapping(path = "addfood")
    public String addFood(Model model) {
        AddNewFoodEntity addNewFoodEntity = new AddNewFoodEntity();
        model.addAttribute("addNewFoodFromController",addNewFoodEntity);
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



    @RequestMapping(path = "inventory",method = RequestMethod.GET)
    public String inventory(Model model) {

        List<AddNewFoodEntity> addNewFoodEntities = foodService.getAllFood();
        model.addAttribute("allfood",addNewFoodEntities);

        return "owner/pages/inventory";
    }


    @GetMapping(path = "lunch")
    public String lunch() {

        return "owner/pages/lunch";
    }


    @PostMapping("/ownerlogin")
    private String ownerLogin(@ModelAttribute("ownerLoginFromController") OwnerEntity ownerEntity, HttpServletRequest request){
        /*System.out.println(ownerEntity.getOw_email());
        System.out.println(ownerEntity.getOw_pwd());*/

        OwnerEntity ownerLog = ownerService.ownerLogin(ownerEntity.getOw_email(),ownerEntity.getOw_pwd());
        //session
        List<String> ownerLoginSession= (List<String>) request.getSession().getAttribute("ADMIN_SESSION");


        if(Objects.nonNull(ownerLog)) {
            if(ownerLoginSession==null){
                ownerLoginSession=new ArrayList<>();
                request.getSession().setAttribute("ADMIN_SESSION",ownerLoginSession);
            }
            ownerLoginSession.add(ownerLog.getOw_id().toString());
            ownerLoginSession.add(ownerLog.getOw_name());
            ownerLoginSession.add(ownerLog.getOw_email());
            ownerLoginSession.add(ownerLog.getOw_mobile());

            request.getSession().setAttribute("ADMIN_SESSION",ownerLoginSession);

            return "redirect:/owner_home";
        }else {
            return "redirect:/admin_login";
        }

    }

    @PostMapping("/AddNewFoodService")
    private String addNewFood(@ModelAttribute("addNewFoodFromController")AddNewFoodEntity addNewFoodEntity){

        //addNewFoodEntity.setCategory_type("asd");
        foodService.addfoodtodb(addNewFoodEntity);
        return "redirect:/addfood?success";
    }



}
