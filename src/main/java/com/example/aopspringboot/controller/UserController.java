package com.example.aopspringboot.controller;

import com.example.aopspringboot.model.User;
import com.example.aopspringboot.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Optional;

@RestController

public class UserController {
    @Autowired
    IUserService userService;

    @GetMapping("/user")
    public ModelAndView showList(){
        ModelAndView modelAndView = new ModelAndView("/list");
        modelAndView.addObject("user",userService.findAll());
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreate(){
        ModelAndView modelAndView =new ModelAndView("/create");
        modelAndView.addObject("user",new User());
        return modelAndView;
    }
    @PostMapping("/create-user")
    public ModelAndView saveUser(@Valid @ModelAttribute ("user") User user, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return new ModelAndView("/create");
        }
        else {
            userService.save(user);
          ModelAndView modelAndView =new ModelAndView("/create");
          modelAndView.addObject("user",new User());
          modelAndView.addObject("message","OK");
          return modelAndView;
        }
    }
    @GetMapping("/edit-user/{id}")
    public ModelAndView showEdit(@PathVariable Long id) throws Exception {
        Optional<User> user = userService.findById(id);
        if(user == null){
            throw new Exception();//bắt lỗi ngoại lệ
        }else {
            ModelAndView modelAndView = new ModelAndView("/edit");
            modelAndView.addObject("user",user);
            return modelAndView;
        }
    }

    // ngoại lệ
    @ExceptionHandler(Exception.class)
    public ModelAndView handleException(){
        return new ModelAndView("/error");
    }
}
