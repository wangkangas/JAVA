package com.example.demo.Controller;

import com.example.demo.Pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@RestController
public class TestController {


    private Logger logger = Logger.getLogger(String.valueOf(TestController.class));
    @Autowired
    private DiscoveryClient discoveryClient;
    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String index(){
        List<ServiceInstance> serviceInstance = discoveryClient.getInstances("hello-service");
        for (ServiceInstance serviceInstanc:serviceInstance) {
            logger.info("/hello host"+serviceInstanc.getHost()+" serviceid "+serviceInstanc.getServiceId());
        }

       return "hello,world";

    }


        @GetMapping("/user")
    public List<User> getalluser(){
        User user1 = new User("lisi","男");
        User user2 = new User("wangwi","女");
        List<User> users = new ArrayList<User>();
        users.add(user1);
        users.add(user2);
        return  users;
    }


    @GetMapping("/userid/{id}")
    public User getalluserbyid(@PathVariable("id") Long id){
        User user1 = new User("lisi","男");
        User user2 = new User("wangwi","女");
        List<User> users = new ArrayList<User>();
        users.add(user1);
        users.add(user2);

        User resp_user = users.get(Math.toIntExact(id));
        return  resp_user;
    }
}

