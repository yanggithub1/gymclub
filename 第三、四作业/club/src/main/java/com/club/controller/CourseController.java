package com.club.controller;

import com.club.WebfluxHandler.CourseHandler;
import com.club.consumer.ConsumerThread;
import com.club.model.CourseEntity;
import com.club.producer.KafkaProducerDemo;
import com.club.repository.courseRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.hateoas.config.EnableEntityLinks;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.reactive.function.server.ServerRequest;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


@RestController
@EnableEntityLinks
public class CourseController {

    @Resource(name = "kafkaProducerDemo")
    KafkaProducerDemo producer;

    @Autowired
    courseRepository courseRepository;
    List<CourseEntity> lists_unchosen = new ArrayList<CourseEntity>();


    @RequestMapping(value = "getcourse/{name}")
    public ModelAndView login(@PathVariable("name") String loged) {
//        List<CourseEntity> list=new ArrayList<CourseEntity>();
//        list=(List<CourseEntity>) courseRepository.findAll();
//        cache_course(loged);
//        for(CourseEntity courseEntity:cache_course(loged)) {
//            System.out.println("course loged is："+courseEntity.getCourseId());
//        }
        List<CourseEntity> lists = new ArrayList<CourseEntity>();
        //多表查询，挑选出等级较高的教练所教授的课程
        lists = courseRepository.getHigh("lean");
//        if(lists.isEmpty()) {
//            System.out.println("noduobiao");
//        }
//        for(CourseEntity courseEntity:lists) {
//            System.out.println("多表："+courseEntity.getCourseId()+" "+courseEntity.getCoachName());
//        }
        ModelAndView mav = new ModelAndView("courses");
        mav.addObject("courselist", cache_course(loged));
        return mav;
    }

    @Cacheable(value = "cachedlist")
    public List<CourseEntity> cache_course(String loged) {
        List<CourseEntity> list1 = new ArrayList<CourseEntity>();
        list1 = (List<CourseEntity>) courseRepository.findAll();
        for (CourseEntity test : list1) {
            if (!test.getUserName().equals(loged)) {
                list1.remove(test.getCourseId());
            }
        }
        return list1;
    }

    @RequestMapping(value = "privacy")
    public ModelAndView getPrivacy() {
        List<CourseEntity> lists = new ArrayList<CourseEntity>();
        //多表查询，挑选出等级较高的教练所教授的课程
        lists = courseRepository.get_Privacy();
        lists_unchosen = courseRepository.get_Privacy();
//        if(lists.isEmpty()) {
//            System.out.println("noduobiao");
//        }
        for (CourseEntity courseEntity : lists) {
            System.out.println("尝试：" + courseEntity.getCourseId() + " " + courseEntity.getCoachName());
        }

        CourseHandler courseHandler=new CourseHandler(courseRepository);
        ServerRequest serverRequest = null;
        System.out.println("WEBFLUX: "+courseHandler.getAll(serverRequest).block());
        ModelAndView mav = new ModelAndView("privacies");
        mav.addObject("privacycourses", lists);


        return mav;
    }

    @RequestMapping(value = "privacy_chosen/{id}/{name}")
    public ModelAndView choosePrivacy(@PathVariable("id") int id, @PathVariable("name") String name) {
        List<CourseEntity> lists = new ArrayList<CourseEntity>();
        //多表查询，挑选出等级较高的教练所教授的课程
        lists = courseRepository.get_Privacy();
        for (CourseEntity courseEntity : lists) {
            if (courseEntity.getCourseId() == id) {
                lists_unchosen.remove(courseEntity);
            }
        }
        String info = "";
        info += String.valueOf(id) + name;
        producer.sendMessage(info);
        ConsumerThread consumerThread = new ConsumerThread();
        Thread thread = new Thread(consumerThread);
        thread.start();
        System.out.println("THE INFO:" + id + name);
        ModelAndView mav = new ModelAndView("privacies");
        mav.addObject("privacycourses", lists_unchosen);
        return mav;
    }

}

