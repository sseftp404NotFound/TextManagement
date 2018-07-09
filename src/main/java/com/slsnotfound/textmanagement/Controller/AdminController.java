package com.slsnotfound.textmanagement.Controller;

import com.slsnotfound.textmanagement.Model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
public class AdminController {

    @RequestMapping("/admin/identitymanage")
    public String index(ModelMap modelMap, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if(user!=null){
            modelMap.addAttribute("username",user.getUsername());
        }
        return "identitymanage_admin";
    }
}