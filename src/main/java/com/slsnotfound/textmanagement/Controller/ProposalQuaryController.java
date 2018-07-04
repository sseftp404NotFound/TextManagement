package com.slsnotfound.textmanagement.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class ProposalQuaryController {
    @RequestMapping(path = "/user/ProposalQuary", method = RequestMethod.GET)
    public String login() {
        return "ProposalQuary";
    }
}
