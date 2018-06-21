package com.serverstatic.action;

import com.serverstatic.client.TestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Create By CJH on 2018/5/17
 */
@RestController
public class TestController {

    @Autowired
    private TestClient testClient;

    @RequestMapping("hello2")
    public String hello () {
        return testClient.hello();
    }


}