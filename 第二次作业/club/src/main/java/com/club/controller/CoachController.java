package com.club.controller;


import com.club.model.CoachEntity;
import com.club.model.CourseEntity;
import com.club.repository.coachRepository;
import com.club.repository.courseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import org.springframework.web.servlet.mvc.LastModified;
import org.springframework.data.domain.Pageable;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RestController
public class CoachController{
    @Autowired
    coachRepository coachRepository;

    private long lastModified = System.currentTimeMillis();

    @RequestMapping(value="getcoachs")
    protected ModelAndView test()  {
        List<CoachEntity> lists=new ArrayList<CoachEntity>();
        //多表查询，挑选出等级较高的教练所教授的课程
        lists=coachRepository.findAll();
//        for(CoachEntity coachEntity:lists) {
//            System.out.println("jiaolianmen："+coachEntity.getCoachName()+" "+coachEntity.getCoachLevel());
//        }
        ModelAndView mav = new ModelAndView("coach");
        mav.addObject("coached",lists);
        return mav;
    }






}
