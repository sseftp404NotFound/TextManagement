package com.slsnotfound.textmanagement.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class LoginController {
    @RequestMapping(path = "/user/Login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }
}
