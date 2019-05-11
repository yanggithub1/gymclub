package com.club.controller;

import com.club.model.CoachEntity;
import com.club.model.UserEntity;
import com.club.model.coachTest;
import com.club.model.token;
import com.club.repository.userRepository;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.LastModified;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController  {

    @Autowired
    userRepository userRepository;

//    private long lastModified = System.currentTimeMillis();

    @RequestMapping(value="main")
    public ModelAndView main(String username, String password) throws Exception{
        //验证传递过来的参数是否正确，否则返回到登陆页面。
        int number=0;
        token token=new token();
        token.setToken_num(0);
        AccessClient accessClient = new AccessClient(token);
        try {
            number=accessClient.access();
        } catch (Exception e) {
            e.printStackTrace();
        }
        cache(username);
        List<UserEntity> list=new ArrayList<UserEntity>();
        list=(List<UserEntity>) userRepository.findAll();
//        System.out.println("USER: "+list);
//        System.out.println("start");
//        if(webRequest.checkNotModified(lastModified)){
//            System.out.println("check : "+lastModified);
//            return null;
//        }
//        System.out.println("no check : "+lastModified);
        int iscontained=0;
        for(UserEntity user:list) {
//            System.out.println("data: "+user.getUserName()+" "+user.getPassword());
            if(user.getUserName().equals(username)&&user.getPassword().equals(password)) {
                iscontained=1;
            }
        }
        if(iscontained==1&&number>3) {
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


//    @Override
//    public long getLastModified(HttpServletRequest httpServletRequest) {
//        return lastModified;
//    }
}
