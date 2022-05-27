package com.codebuffer.user.controller;

import com.codebuffer.user.Entity.User;
import com.codebuffer.user.VO.ResponseTemplateVO;
import com.codebuffer.user.repository.UserRepository;
import com.codebuffer.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users" )
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/")
    public User saveUser(@RequestBody User user){
        log.info("Inside saveUser of UserService" );
        return userService.saveUser(user);
    }
    @GetMapping("/{id}")
    public ResponseTemplateVO getUserWithDepartment(@PathVariable("id") Long userId){
        log.info("Inside getUserWithDepartment of UserService");
        return userService.getUserWithDepartment(userId);
    }

}

