package com.serverone.controller;

import com.serverone.model.Employee;
import com.serverone.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

/**
 * Create By CJH on 2018/5/17
 */
@RestController
public class TestController {
    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("hello")
    public String hello () {
//        int a = 1/0;
        return "hello";
    }

    @RequestMapping("test")
    public String baseType (@RequestParam("xage") int age) {
        return "age" + age;
    }

    @RequestMapping("test2")
    public String baseType2 (Integer age) {
        return "age" + age;
    }

    //http://localhost:8090/array?name=tom&name=lily&name=jack
    @RequestMapping("array")
    public String arrayType (String[] name) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String a : name) {
            stringBuilder.append(a).append(" ");
        }
        return stringBuilder.toString();
    }

    @RequestMapping("object")
    public String objectType (Employee employee) {
        return employee.toString();
    }

    @PostMapping(value = "json", produces = MediaType.APPLICATION_JSON_VALUE)
    public String jsonType (@RequestBody Employee employee) {
        return employee.toString();
    }

    @InitBinder("employee")
    public void bindEmployee (WebDataBinder binder) {
        binder.setFieldDefaultPrefix("employee.");
    }

}