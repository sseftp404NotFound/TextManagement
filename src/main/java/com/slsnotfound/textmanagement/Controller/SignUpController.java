package com.slsnotfound.textmanagement.Controller;

import com.slsnotfound.textmanagement.Dao.UserDao;
import com.slsnotfound.textmanagement.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class SignUpController {

    @Autowired
    private UserDao userDao;

    @RequestMapping(path = "/signup", method = RequestMethod.GET)
    public String signin() {
        return "signup";
    }

    @RequestMapping(path = "/user/checkusername", method = RequestMethod.POST)
    @ResponseBody
    String checkUser(@RequestParam("username") String username) {
        User user = userDao.getUserByUsername(username);
        if (user != null) {
            return "invalid";
        } else {
            return "valid";
        }
    }

    @RequestMapping(path = "/user/signup", method = RequestMethod.POST)
    public String loginAction(HttpSession session,
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
        int result=userDao.insert(user);
        if(result<=0){
            session.setAttribute("message","Sorry!");
            session.setAttribute("message2","Database Wrong!");
            session.setAttribute("message3","Please Sign Up again!");
            return "redirect:/signupresult";
        }else{
            session.setAttribute("message","Checking!");
            session.setAttribute("message2","Please Wait!");
            session.setAttribute("message3","Or Return Sign In!");
            return "redirect:/signupresult";
        }
    }
}
