package com.ilyasov;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class PageController {
public static ArrayList list = new ArrayList();
    @RequestMapping(value = "/start",method = RequestMethod.GET)
    public String getIndexPage(ModelMap modelMap){
        return "start";
    }
    @RequestMapping(value = "/list/{number}",method = RequestMethod.POST)
    public String getResultPage(ModelMap modelMap,@PathVariable("number") int number , @RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName, @RequestParam("middleName") String middleName, @RequestParam("age") String age, @RequestParam("sex") String sex){
        User user = new User();
        if (!firstName.equals("")){
        user.setFirstName(firstName);}
        if(!lastName.equals("")){
        user.setLastName(lastName);}
        if(!middleName.equals("")){
        user.setMiddleName(middleName);}
        if (!age.equals("")){
        user.setAge(age);}
        if(!sex.equals("")){
        user.setSex(sex);}
        list.add(user);
        modelMap.addAttribute("list",list);
        modelMap.addAttribute("message", "list number "+number);
        return "list";
    }
    @RequestMapping(value = "/list/{number}",method = RequestMethod.GET)
    public String getResultPage(ModelMap modelMap,@PathVariable("number") int number){
        modelMap.addAttribute("list",list);
        modelMap.addAttribute("message", "Welcome to list number "+number);
        return "list";
    }

}
