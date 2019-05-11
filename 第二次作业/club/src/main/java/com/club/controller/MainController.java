package com.club.controller;
import com.club.model.token;
import com.club.repository.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.config.EnableEntityLinks;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@EnableEntityLinks
public class MainController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView indexs() {
        return new ModelAndView("index");
    }

}
