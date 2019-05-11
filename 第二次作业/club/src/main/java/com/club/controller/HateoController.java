package com.club.controller;

import com.club.model.Hateo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityLinks;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.config.EnableEntityLinks;
import org.springframework.hateoas.config.EnableHypermediaSupport;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.core.DummyInvocationUtils.methodOn;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

@RestController
@ExposesResourceFor(Hateo.class)
@RequestMapping(path = "/lists")


//@EnableHypermediaSupport(type= {EnableHypermediaSupport.HypermediaType.HAL})
public class HateoController {



//    @Autowired
//    private EntityLinks entityLinks;


    private String sentense= "Hello, ycb!";

    @RequestMapping("/greeting")
    public HttpEntity<Hateo> greeting() {
        Hateo greeting = new Hateo(sentense);
//        greeting.add(linkTo(methodOn(HateoController.class).greeting(name)).withSelfRel());
        greeting.add(new Link("http://localhost:8080"));
        greeting.add(new Link("http://localhost:8080/main", "items"));
        greeting.add(new Link("www.baidu.com"));
        return new ResponseEntity<>(greeting, HttpStatus.OK);
    }

//    @RequestMapping("/greeting/{id}")
//    public HttpEntity<Greeting> lists(@RequestParam(value = "name", required = false, defaultValue = "World") String name, @PathVariable(value = "id") String id) {
//
//        Greeting greeting = new Greeting(String.format(TEMPLATE, name));
//        greeting.add(linkTo(methodOn(GreetingController.class).greeting(name)).withSelfRel());
//        greeting.add(linkTo(GreetingController.class).slash(id).withSelfRel());
//        greeting.add(new Link("http://localhost:8080/lists/1/items", "items"));
//
//
////        greeting.add(entityLinks.linkForSingleResource(Greeting.class, 1).withSelfRel());
//
//        return new ResponseEntity<>(greeting, HttpStatus.OK);
//    }
}
