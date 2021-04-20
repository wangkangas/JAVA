package com.example.demo.FeignService;

import com.example.demo.Pojo.User;
import org.springframework.stereotype.Component;

@Component
public class FallbackController implements Controller {
    @Override
    public String feignBase() {
        return "feign base no paramter error";
    }

    @Override
    public String feignBase(String name) {
        return "feign base single paramter error";
    }

    @Override
    public User feignBase(String name, Integer age) {
        return new User("feign base multi paramter error",0);
    }

    @Override
    public String feignBase(User user) {
        return "feign base user paramter error";
    }
}
