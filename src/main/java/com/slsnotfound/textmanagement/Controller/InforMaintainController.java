package com.slsnotfound.textmanagement.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class InforMaintainController {
    @RequestMapping(path = "/user/InforMaintain", method = RequestMethod.GET)
    public String login() {
        return "InforMaintain";
    }
}
