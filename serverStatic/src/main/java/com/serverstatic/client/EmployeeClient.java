package com.serverstatic.client;

import com.alibaba.fastjson.JSONObject;
import com.serverstatic.vo.Employee;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * Create By CJH on 2018/5/24
 */
@FeignClient(value = "serverone")
public interface EmployeeClient {
    String PATH = "employee";

    @GetMapping(value = PATH + "")
    JSONObject list(@RequestParam("limit") Integer limit, @RequestParam("offset") Integer offset);

    @PostMapping(value = PATH + "", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE}, consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    JSONObject addEmployee(@RequestBody Employee employee);

    @PutMapping(value = PATH + "", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE}, consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    JSONObject updateEmployee(@RequestBody Employee employee);

    @DeleteMapping(value = PATH + "", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE}, consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    JSONObject deleteEmployee(@RequestBody Employee employee);
}