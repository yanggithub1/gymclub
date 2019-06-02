package com.club.controller;

import com.club.model.CoachEntity;
import com.club.model.coachTest;
import com.club.repository.coachRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/user")
@Api(value = "/user", tags = "User接口")
public class docuController {

    @Autowired
    com.club.repository.coachRepository coachRepository;

    @RequestMapping(value = "/getUser/{id}", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "添加教练", notes = "添加教练", httpMethod = "GET", response = CoachEntity.class)
    public ResponseEntity<CoachEntity> getUser(@PathVariable String name, @PathVariable int level) {

        CoachEntity entity = new CoachEntity();
        entity.setCoachLevel(5);
        entity.setCoachName("jack");
        coachRepository.save(entity);
        return ResponseEntity.ok(entity);
    }

}
