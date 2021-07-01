package com.canteen.CMS.Controller;

import com.canteen.CMS.Entity.AddNewFoodEntity;
import com.canteen.CMS.Entity.OwnerEntity;
import com.canteen.CMS.Services.AddNewFoodService;
import com.canteen.CMS.Services.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@Controller
public class Owner {

    @Autowired
    private OwnerService ownerService;

    @Autowired
    private AddNewFoodService addNewFoodService;


    @GetMapping(path = "owner_home")
    public String home() {

        return "owner/index";
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

        List<AddNewFoodEntity> addNewFoodEntities = addNewFoodService.getAllFood();
        model.addAttribute("allfood",addNewFoodEntities);

        return "owner/pages/inventory";
    }


    @GetMapping(path = "lunch")
    public String lunch() {

        return "owner/pages/lunch";
    }


    @PostMapping("/ownerlogin")
    private String ownerLogin(@ModelAttribute("ownerLoginFromController") OwnerEntity ownerEntity){
        /*System.out.println(ownerEntity.getOw_email());
        System.out.println(ownerEntity.getOw_pwd());*/

        OwnerEntity ownerLog = ownerService.ownerLogin(ownerEntity.getOw_email(),ownerEntity.getOw_pwd());

        if (Objects.nonNull(ownerLog)) {

            return "redirect:/owner_home";
        }
        else {
            return "redirect:/admin_login";
        }



    }

    @PostMapping("/AddNewFoodService")
    private String addNewFood(@ModelAttribute("addNewFoodFromController")AddNewFoodEntity addNewFoodEntity){

        //addNewFoodEntity.setCategory_type("asd");
        addNewFoodService.addfoodtodb(addNewFoodEntity);
        return "redirect:/addfood?success";
    }



}