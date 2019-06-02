package com.club.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.annotation.Resource;

import com.club.consumer.ConsumerThread;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.club.consumer.KafkaConsumerDemo;
import com.club.producer.KafkaProducerDemo;

@RestController
public class KafkaController {

    @Resource(name = "kafkaProducerDemo")
    KafkaProducerDemo producer;

    @Resource(name = "kafkaConsumerDemo")
    KafkaConsumerDemo consumer;

    @RequestMapping(value = "/welcome")
    public ModelAndView welcome() {
        System.out.println("--------welcome--------");
        ModelAndView mv = new ModelAndView();
        mv.setViewName("welcome");
        return mv;
    }

    @RequestMapping(value = "/sendmessage", method = RequestMethod.GET)
    public ModelAndView sendMessage() {
        System.out.println("--------sendmessage--------");
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String now = sdf.format(date);

        ModelAndView mv = new ModelAndView();
        mv.addObject("time", now);
        mv.setViewName("kafka_send");
        return mv;
    }

    @RequestMapping(value = "/onsend", method = RequestMethod.POST)
    public ModelAndView onsend(@RequestParam("message") String msg) {
        System.out.println("--------onsend--------");
        producer.sendMessage(msg);
        ConsumerThread consumerThread = new ConsumerThread();
        Thread thread = new Thread(consumerThread);
        thread.start();
        ModelAndView mv = new ModelAndView();
        mv.setViewName("welcome");
//        consumer.receive();
        return mv;
    }

    @RequestMapping(value = "/receive")
    public ModelAndView receive() {
        System.out.println("--------receive--------");
        ArrayList<String> msgs = consumer.receive();
//        String msg = consumer.receive();
        System.out.println("hhhhh!!!!!!!!!!!" + msgs.size());
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg", msgs);
        mv.setViewName("kafka-receive");
        return mv;
    }
}
