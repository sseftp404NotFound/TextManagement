package com.slsnotfound.textmanagement.Controller;

import com.slsnotfound.textmanagement.Model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class testController {
    @RequestMapping("/test")
    public String index(ModelMap modelMap, HttpSession session) {
        String s = (String) session.getAttribute("message");
        if(s!=null){
            modelMap.addAttribute("message",s);
        }
        return "test";
    }
}
