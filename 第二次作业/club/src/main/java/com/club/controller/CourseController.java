package com.club.controller;
import com.club.model.CourseEntity;
import com.club.model.UserEntity;
import com.club.repository.courseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.hateoas.config.EnableEntityLinks;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;


@RestController
@EnableEntityLinks
public class CourseController {
    @Autowired
    courseRepository courseRepository;

    @RequestMapping(value="getcourse/{name}")
    public ModelAndView login(@PathVariable("name") String loged){
//        List<CourseEntity> list=new ArrayList<CourseEntity>();
//        list=(List<CourseEntity>) courseRepository.findAll();
//        cache_course(loged);
//        for(CourseEntity courseEntity:cache_course(loged)) {
//            System.out.println("course loged is："+courseEntity.getCourseId());
//        }
        List<CourseEntity> lists=new ArrayList<CourseEntity>();
        //多表查询，挑选出等级较高的教练所教授的课程
        lists=courseRepository.getHigh("lean");
//        if(lists.isEmpty()) {
//            System.out.println("noduobiao");
//        }
//        for(CourseEntity courseEntity:lists) {
//            System.out.println("多表："+courseEntity.getCourseId()+" "+courseEntity.getCoachName());
//        }
        ModelAndView mav = new ModelAndView("courses");
        mav.addObject("courselist",cache_course(loged));
        return mav;
    }

    @Cacheable(value="cachedlist")
    public List<CourseEntity> cache_course(String loged) {
        List<CourseEntity> list1=new ArrayList<CourseEntity>();
        list1=(List<CourseEntity>) courseRepository.findAll();
        for(CourseEntity test:list1) {
            if(!test.getUserName().equals(loged)) {
                list1.remove(test.getCourseId());
            }
        }
        return list1;
    }
}
