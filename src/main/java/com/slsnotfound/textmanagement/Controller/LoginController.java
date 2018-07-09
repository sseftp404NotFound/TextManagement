package com.slsnotfound.textmanagement.Controller;

import com.slsnotfound.textmanagement.Dao.UserDao;
import com.slsnotfound.textmanagement.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    private UserDao userDao;

    @RequestMapping(path = "/user/Login", method = RequestMethod.GET)
    public String login() {
        return "Login";
    }

    @RequestMapping(path = "/user/Login", method = RequestMethod.POST)
    public String loginAction(ModelMap modelMap,
                              HttpSession session,
                              @RequestParam("username") String username,
                              @RequestParam("password") String password) {
        User user = userDao.getUserByUsername(username);
        if (user!=null){
            if (password.equals(user.getPassword())&&user.getRole()==0&&user.getStatus()==1){
                session.setAttribute("user",user);
                return "redirect:/ProposalQuary";
            }else if(password.equals(user.getPassword())&&user.getRole()==0&&user.getStatus()==0){
                modelMap.addAttribute("message", "Checking!Please Wait!");
                return "Login";
            }else if(password.equals(user.getPassword())&&user.getRole()==0&&user.getStatus()==-1){
                modelMap.addAttribute("message", "The user has not passed the check!");
                return "Login";
            }else if(password.equals(user.getPassword())&&user.getRole()==1){
                session.setAttribute("user",user);
                return "redirect:/IdentityManage";
            }else {
                modelMap.addAttribute("message", "Wrong Password!");
                return "Login";
            }
        }else{
            modelMap.addAttribute("message", "The User Not Exist!Please Sign Up!");
            return "Login";
        }
    }
}

