package com.club.controller;

import com.club.model.CoachEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class PageController {
    @Autowired
    com.club.repository.coachRepository coachRepository;


    @RequestMapping(value = "pagecoach/list")
    public ModelAndView listUser(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                 @RequestParam(value = "size", defaultValue = "3") Integer size) {
        ModelAndView modelAndView = new ModelAndView("list");
        PageRequest request = new PageRequest(page - 1, size);
        Page<CoachEntity> coachPage = coachRepository.findAll(request);
        List<CoachEntity> coachEntityList = coachPage.getContent();
        if (coachEntityList.isEmpty()) {
            System.out.println("coach list is null");
        } else {
            System.out.println(coachEntityList.get(0).getCoachName());
        }
        Page<CoachEntity> coachEntityPage = new PageImpl<>(coachEntityList, request, coachPage.getTotalElements());
        modelAndView.addObject("coachPage", coachEntityPage);
        return modelAndView;
    }
}
