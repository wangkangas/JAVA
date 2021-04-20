package com.example.demo.ProviderController;

import com.example.demo.Pojo.User;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {

    @GetMapping("/hello")
    public String feignBase(){
        return "hello";
    }

    @GetMapping("/hello1")
    public String feignBase(@RequestParam String name){
        return "hello"+name;
    }


    @GetMapping("/hello2")
    public User feignBase(@RequestHeader String name, @RequestHeader Integer age){
        return new User(name,age);
    }

    @PostMapping("/hello3")
    public String feignBase(@RequestBody User user){
        return "hello" + user.getName()+user.getAge();
    }

}
