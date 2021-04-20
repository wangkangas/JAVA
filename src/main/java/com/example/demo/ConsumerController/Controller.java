package com.example.demo.ConsumerController;

import com.example.demo.Pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @Autowired
    com.example.demo.FeignService.Controller helloservice;
    @GetMapping("/BaseFeign")
    public String FeignTest01(){
        return helloservice.feignBase();
    }

    @GetMapping("/BaseFeign1")
    public String FeignTest02(){
       return  helloservice.feignBase("lisi");
    }


    @GetMapping("/BaseFeign2")
    public User FeignTest03(){
        return helloservice.feignBase("liqin",32);
    }

    @GetMapping("/BaseFeign3")
    public String FeignTest04(){
        return  helloservice.feignBase(new User("lisi",15));
    }
}
