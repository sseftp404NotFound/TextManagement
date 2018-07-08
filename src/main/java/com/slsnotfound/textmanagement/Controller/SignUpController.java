package com.slsnotfound.textmanagement.Controller;

import com.slsnotfound.textmanagement.Dao.UserDao;
import com.slsnotfound.textmanagement.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import javax.validation.constraints.Null;

@Controller
public class SignUpController {

    @Autowired
    private UserDao userDao;

    @RequestMapping(path = "/user/SignUp", method = RequestMethod.GET)
    public String login() {
        return "SignUp";
    }

    @RequestMapping(path = "/user/CheckUsername", method = RequestMethod.POST)
    @ResponseBody
    String checkUser(@RequestParam("username") String username) {
        User user = userDao.getUserByUsername(username);
        if (user != null) {
            return "invalid";
        } else {
            return "valid";
        }
    }

    @RequestMapping(path = "/user/SignUp", method = RequestMethod.POST)
    public String loginAction(ModelMap modelMap,
                              @RequestParam("username") String username,
                              @RequestParam("sex") String sex,
                              @RequestParam("birthday") String birthday,
                              @RequestParam("password") String password,
                              @RequestParam("phonenum") String phonenum,
                              @RequestParam(value = "address",required = false)String address,
                              @RequestParam(value = "referrer",required = false) String referrer,
                              @RequestParam("industry") String industry,
                              @RequestParam("committee") String committee
                              ) {
        User user=new User(username,sex,birthday,password,phonenum,address,referrer,industry,committee);
        System.out.println(user.getReferrer());
        System.out.println(user.getCommittee());
        System.out.println(user.getIndustry());
        int result=userDao.insert(user);
        System.out.println(result);
        return "SignUpResult";
    }
}
