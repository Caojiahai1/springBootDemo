package com.serverstatic.client.failback;

import com.alibaba.fastjson.JSONObject;
import com.serverstatic.client.EmployeeClient;
import com.serverstatic.vo.Employee;
import org.springframework.stereotype.Component;

/**
 * Create By CJH on 2018/5/24
 */
@Component
public class EmployeeFailback implements EmployeeClient {
    @Override
    public JSONObject list(Integer limit, Integer offset) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("success",false);
        return jsonObject;
    }

    @Override
    public JSONObject addEmployee(Employee employee) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("success",false);
        return jsonObject;
    }

    @Override
    public JSONObject updateEmployee(Employee employee) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("success",false);
        return jsonObject;
    }

    @Override
    public JSONObject deleteEmployee(Employee employee) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("success",false);
        return jsonObject;
    }
}