package com.serverstatic.client.failback;

import com.serverstatic.client.TestClient;
import org.springframework.stereotype.Component;

/**
 * Create By CJH on 2018/5/17
 */
@Component
public class TestFailback implements TestClient {
    @Override
    public String hello() {
        return "111";
    }
}