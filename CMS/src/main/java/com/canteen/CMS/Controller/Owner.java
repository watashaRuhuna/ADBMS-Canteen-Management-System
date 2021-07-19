package com.canteen.CMS.Controller;

import com.canteen.CMS.Entity.AddNewFoodEntity;
import com.canteen.CMS.Entity.OrderEntity;
import com.canteen.CMS.Entity.OwnerEntity;
import com.canteen.CMS.Services.FoodService;
import com.canteen.CMS.Services.OrderService;
import com.canteen.CMS.Services.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Controller
public class Owner {

    @Autowired
    private OwnerService ownerService;

    @Autowired
    private FoodService foodService;

    @Autowired
    private OrderService orderService;


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
    @RequestMapping(path = "breakfirst",method = RequestMethod.GET)
    public String breakfirst(Model model) {

        List<OrderEntity> breakFirst = orderService.breakfirstOrders();
        model.addAttribute("breakfirst",breakFirst);
        return "owner/pages/breakfirst";
    }

    @GetMapping(path = "lunch")
    public String lunch() {

        return "owner/pages/lunch";
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

    //adding food
    @PostMapping("/AddNewFoodService")

    private String addNewFood(@ModelAttribute("addNewFoodFromController")AddNewFoodEntity addNewFoodEntity,@RequestParam("imgfood") MultipartFile file
    ){
        //image
        Path resourceDirectory = Paths.get("src","main","resources","static","assets","food_");
        //CMS\src\main\resources\static\assets
        String absoluteLink= resourceDirectory.toFile().getAbsolutePath();
        try {
            file.transferTo(new File(absoluteLink + file.getOriginalFilename()));
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        System.out.println(absoluteLink);
        System.out.println(file);
        addNewFoodEntity.setImg(file.getOriginalFilename());

        //image end

        foodService.addfoodtodb(addNewFoodEntity);
        return "redirect:/addfood?success";
    }

    @PostMapping("/updateInventory")

    private String updateInventory(@RequestParam("foodid") Integer id,@RequestParam("price") Float price,@RequestParam("qty") Integer qty){

        //form data here
            /*System.out.println(id);
            System.out.println(price);
            System.out.println(qty);*/

        //pass data to OwnerService
        //method updateFood
        if(ownerService.updateFood(id,price,qty)){
            return "redirect:/inventory?success";
        }else{
            return "redirect:/inventory?error";
        }


    }
/*    @PostMapping("/issueorder")

    private String issueOrder(@RequestParam("foodid") Integer id,@RequestParam("price") Float price,@RequestParam("qty") Integer qty){



    return null;
    }*/



}
