package com.slsnotfound.textmanagement.Controller;

import com.slsnotfound.textmanagement.Model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
public class SignUpResultController {
    @RequestMapping(path = "/user/SignUpResult", method = RequestMethod.GET)
    public String login() {
        return "SignUpResult";
    }

    @RequestMapping("/SignUpResult")
    public String index(ModelMap modelMap, HttpSession session) {
        String s = (String) session.getAttribute("message");
        String s2 = (String) session.getAttribute("message2");
        String s3 = (String) session.getAttribute("message3");
        modelMap.addAttribute("message",s);
        modelMap.addAttribute("message2",s2);
        modelMap.addAttribute("message3",s3);
        return "SignUpResult";
    }
}
