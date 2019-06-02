package com.club.controller;


import com.club.model.CourseEntity;
import com.club.model.Hateo;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
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
public class LinkController implements LastModified {

    private long lastModified = System.currentTimeMillis();

    @RequestMapping(value = "getlinks")
    public ModelAndView getlinks(WebRequest webRequest, HttpServletRequest request) throws Exception {
        HateoController hateoController = new HateoController();
        HttpEntity<Hateo> hateoHttpEntity = hateoController.greeting();
        System.out.println("ssss: ");
        System.out.println(hateoHttpEntity);
//        System.out.println("LINKS: "+hateoHttpEntity.getBody().getLinks().get(2).getHref());
        ArrayList<String> links = new ArrayList<String>();
        links.add(hateoHttpEntity.getBody().getLinks().get(0).getHref());
        links.add(hateoHttpEntity.getBody().getLinks().get(1).getHref());
        links.add(hateoHttpEntity.getBody().getLinks().get(2).getHref());

        System.out.println("start");
        if (webRequest.checkNotModified(lastModified)) {
            System.out.println("check : " + lastModified);
            return null;
        }
        System.out.println("no check : " + lastModified);
        ModelAndView mav = new ModelAndView("links");
        mav.addObject("linklist", links);
        return mav;
    }

    @Override
    public long getLastModified(HttpServletRequest httpServletRequest) {
        return lastModified;
    }
}
