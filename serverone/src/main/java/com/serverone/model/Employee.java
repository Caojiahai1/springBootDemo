package com.serverone.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Table;
import java.util.Date;

/**
 * Create By CJH on 2018/5/5
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true)
@Table(name = "employee")
public class Employee {
    private Integer id;
    private String username;
    private String usercode;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date hiredate;
    private String sex;
    private int age;
}