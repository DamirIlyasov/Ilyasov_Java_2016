package com.ilyasov;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PageController {
    public static List list = new ArrayList();

    @RequestMapping(value = "/start", method = RequestMethod.GET)
    public String getIndexPage(Model model) {
        return "start";
    }

    @RequestMapping(value = "/list/{number}", method = RequestMethod.POST)
    public String getResultPage(Model model, @PathVariable("number") int number, @RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName, @RequestParam("middleName") String middleName, @RequestParam("date") String date, @RequestParam("sex") String sex) {
        User user = createUser(firstName, lastName, middleName, date, sex);
        list.add(user);
        model.addAttribute("list", list);
        model.addAttribute("message", "list number " + number);
        return "list";
    }

    @RequestMapping(value = "/list/{number}", method = RequestMethod.GET)
    public String getResultPage(ModelMap modelMap, @PathVariable("number") int number) {
        modelMap.addAttribute("list", list);
        modelMap.addAttribute("message", "Welcome to list number " + number);
        return "list";
    }

    User createUser(String firstName, String lastName, String middleName, String date, String sex) {
        User user = new User();
        if (!firstName.equals("")) {
            user.setFirstName(firstName);
        }
        if (!lastName.equals("")) {
            user.setLastName(lastName);
        }
        if (!middleName.equals("")) {
            user.setMiddleName(middleName);
        }
        if (!date.equals("")) {
            user.setDate(date);
        }
        if (!sex.equals("")) {
            user.setSex(sex);
        }
        return user;
    }
}
