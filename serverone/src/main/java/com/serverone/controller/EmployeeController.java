package com.serverone.controller;

import com.alibaba.fastjson.JSONObject;
import com.serverone.model.Employee;
import com.serverone.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Create By CJH on 2018/5/24
 */
@RestController
@RequestMapping(value = "employee", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public JSONObject list (HttpServletRequest request, @RequestParam Integer limit, @RequestParam Integer offset) {
        JSONObject jsonObject = new JSONObject();
        List<Employee> list = employeeService.getAll(limit, offset);
        jsonObject.put("rows", list);
        jsonObject.put("total", employeeService.getCount());
        return jsonObject;
    }

    @PostMapping
    public JSONObject add (@RequestBody Employee employee) {
        JSONObject jsonObject = new JSONObject();
        employee.setId(null);
        employeeService.addEmployee(employee);
        jsonObject.put("success", true);
        return jsonObject;
    }

    @PutMapping
    public JSONObject update (@RequestBody Employee employee) {
        JSONObject jsonObject = new JSONObject();
        employeeService.updateEmployee(employee);
        jsonObject.put("success", true);
        return jsonObject;
    }

    @DeleteMapping
    public JSONObject delete (@RequestBody Employee employee) {
        JSONObject jsonObject = new JSONObject();
        employeeService.deleteEmployee(employee);
        jsonObject.put("success", true);
        return jsonObject;
    }

    @GetMapping(value = "getEmpById")
    public Employee getEmpById (@RequestParam Integer id) {
        return employeeService.getEmpById(id);
    }
}