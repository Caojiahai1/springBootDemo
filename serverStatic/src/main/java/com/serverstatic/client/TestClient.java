package com.serverstatic.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Create By CJH on 2018/5/17
 */
@FeignClient(value = "serverone")
public interface TestClient {

    @RequestMapping("hello")
    String hello ();
}