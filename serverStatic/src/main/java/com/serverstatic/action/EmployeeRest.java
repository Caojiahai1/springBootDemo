package com.serverstatic.action;

import com.alibaba.fastjson.JSONObject;
import com.serverstatic.client.EmployeeClient;
import com.serverstatic.vo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * Create By CJH on 2018/5/24
 */
@RestController
@RequestMapping(value = "employee", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
public class EmployeeRest {
    @Autowired
    private EmployeeClient employeeClient;

    @GetMapping
    public JSONObject list(Integer limit, Integer offset){
        return employeeClient.list(limit, offset);
    };

    @PostMapping
    public JSONObject addEmployee (Employee employee) {
        return employeeClient.addEmployee(employee);
    }

    @PutMapping
    public JSONObject updateEmployee (Employee employee) {
        return employeeClient.updateEmployee(employee);
    }

    @DeleteMapping
    public JSONObject deleteEmployee (Employee employee) {
        return employeeClient.deleteEmployee(employee);
    }
}