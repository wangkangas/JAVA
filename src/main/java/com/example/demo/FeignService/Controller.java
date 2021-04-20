package com.example.demo.FeignService;

import com.example.demo.Config.SelfConfig;
import com.example.demo.Pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "feign-service-provider",fallback = FallbackController.class,configuration = SelfConfig.class)
public interface Controller {
    @GetMapping("/hello")
    public String feignBase();
    @GetMapping("/hello1")
    public String feignBase(@RequestParam String name);
    @GetMapping("/hello2")
    public User feignBase(@RequestHeader String name,@RequestHeader Integer age);
    @PostMapping("/hello3")
    public String feignBase(@RequestBody User user);
}
