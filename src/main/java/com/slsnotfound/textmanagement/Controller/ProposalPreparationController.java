package com.slsnotfound.textmanagement.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ProposalPreparationController {
    @RequestMapping(path = "/user/ProposalPreparation", method = RequestMethod.GET)
    public String login() {
        return "ProposalPreparation";
    }
}
