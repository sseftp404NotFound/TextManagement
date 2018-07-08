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
public class SignUpController {

    @Autowired
    private UserDao userDao;

    @RequestMapping(path = "/user/SignUp", method = RequestMethod.GET)
    public String login() {
        return "SignUp";
    }

    @RequestMapping(path = "/user/SignUp", method = RequestMethod.POST)
    public String loginAction(ModelMap modelMap,
                              HttpSession session,
                              @RequestParam("username") String username,
                              @RequestParam("sex") String sex,
                              @RequestParam("birthday") String birthday,
                              @RequestParam("password") String password,
                              @RequestParam("phonenum") String phonenum,
                              @RequestParam(value = "address", required = false) String address,
                              @RequestParam(value = "referrer", required = false) String referrer,
                              @RequestParam("industry") String industry,
                              @RequestParam("committee") String committee
                              ) {
        User user=new User(username,sex,birthday,password,phonenum,address,referrer,industry,committee);
        User user1=userDao.getUserByUsername(user.getUsername());
        if(user1!=null){

        }
        return "";
    }
}
