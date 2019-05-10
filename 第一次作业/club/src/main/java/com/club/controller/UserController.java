package com.club.controller;

import com.club.model.UserEntity;
import com.club.repository.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    userRepository userRepository;

    @RequestMapping(value="login",method= RequestMethod.POST)
    public ModelAndView login(String username, String password){
        //验证传递过来的参数是否正确，否则返回到登陆页面。
        cache(username);
        List<UserEntity> list=new ArrayList<UserEntity>();
        list=(List<UserEntity>) userRepository.findAll();
        System.out.println("USER: "+list);
        int iscontained=0;
        for(UserEntity user:list) {
            System.out.println("data: "+user.getUserName()+" "+user.getPassword());
            if(user.getUserName().equals(username)&&user.getPassword().equals(password)) {
                iscontained=1;
            }
        }
        System.out.println("cache: "+cache(username));
        if(iscontained==1) {
            ModelAndView mav = new ModelAndView("main");
            mav.addObject("username",username);
            return mav;
        }
        return new ModelAndView("index");
    }

    @Cacheable(value="usernamecache",key="#username")
    public String cache(String username) {
        return username;
    }


}
