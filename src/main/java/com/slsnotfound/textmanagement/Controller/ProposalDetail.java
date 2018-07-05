package com.slsnotfound.textmanagement.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class ProposalDetail {
    @RequestMapping(path = "/user/ProposalDatail", method = RequestMethod.GET)
    public String login() {
        return "ProposalDatail";
    }
}
