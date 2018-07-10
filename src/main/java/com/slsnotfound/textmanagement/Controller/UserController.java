package com.slsnotfound.textmanagement.Controller;

import com.slsnotfound.textmanagement.Dao.ProposalDao;
import com.slsnotfound.textmanagement.Model.Proposal;
import com.slsnotfound.textmanagement.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    private ProposalDao proposalDao;

    @RequestMapping("/user/proposalquary")
    public String index(ModelMap modelMap, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if(user!=null){
            List<Proposal> proposals = proposalDao.getAll();
            modelMap.addAttribute("username",user.getUsername());
            modelMap.addAttribute("proposals", proposals);
            return "proposalquary_user";
        }else{
            return "redirect:/login";
        }
    }

    @RequestMapping(path = "/user/proposalpreparation")
    public String newproposal(HttpSession session,
                             ModelMap modelMap) {
        User user = (User) session.getAttribute("user");
        if (user != null) {
            modelMap.addAttribute("username", user.getUsername());

            return "proposalpreparation_user";
        } else {
            return "redirect:/login";
        }
    }

    @RequestMapping(path = "/user/informaintain")
    public String informaintain(HttpSession session,
                             ModelMap modelMap) {
        User user = (User) session.getAttribute("user");
        if (user != null) {
            modelMap.addAttribute("username", user.getUsername());
            return "informaintain_user";
        } else {
            return "redirect:/login";
        }
    }

    @RequestMapping(path = "/user/proposalpreparation",method =RequestMethod.POST)
    public String newproposal(HttpSession session,
                              ModelMap modelMap,
                              @RequestParam("name") String name,
                              @RequestParam("text") String text){
        User user=(User) session.getAttribute("user");
        if(user!=null){
            modelMap.addAttribute("username",user.getUsername());
            Proposal proposal=new Proposal(name,user.getUid(),user.getUsername(),text);
            int result=proposalDao.insertProposal(proposal);
            if(result<=0){
                modelMap.addAttribute("message", "Database Wrong!");
                return "redirect:/user/proposalpreparation";
            }else {
                modelMap.addAttribute("message", "Successfully!");
                return "redirect:/user/proposalpreparation";
            }
        }else{
            return "redirect:/login";
        }
    }
}

