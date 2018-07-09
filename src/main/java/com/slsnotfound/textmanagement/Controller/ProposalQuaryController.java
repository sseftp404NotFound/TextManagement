package com.slsnotfound.textmanagement.Controller;

import com.slsnotfound.textmanagement.Dao.ProposalDao;
import com.slsnotfound.textmanagement.Model.Proposal;
import com.slsnotfound.textmanagement.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class ProposalQuaryController {

    @Autowired
    private ProposalDao proposalDao;

    @RequestMapping(path = "/user/ProposalQuary", method = RequestMethod.GET)
    public String login() {
        return "ProposalQuary";
    }

    @RequestMapping("/ProposalQuary")
    public String index(ModelMap modelMap, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if(user!=null){
            List<Proposal> proposals = proposalDao.getAll();
            modelMap.addAttribute("username",user.getUsername());
            modelMap.addAttribute("proposals", proposals);
            return "ProposalQuary";
        }else{
            return "redirect:/user/login";
        }
    }

}
