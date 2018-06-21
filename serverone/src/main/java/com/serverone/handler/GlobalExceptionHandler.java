package com.serverone.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Create By CJH on 2018/5/25
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    private Map<String, Object> handler (HttpServletRequest request, Exception e) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        modelMap.put("success", false);
        modelMap.put("ErrorMsg", e.getMessage());
        return modelMap;
    }
}