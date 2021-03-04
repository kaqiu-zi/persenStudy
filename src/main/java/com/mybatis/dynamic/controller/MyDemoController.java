package com.mybatis.dynamic.controller;

import com.mybatis.dynamic.entity.Task;
import com.network.common.ApiResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 *
 *
 * @author kaqiu-omj
 * @version 1.0 2020/12/23 13:43
 * @since 1.0.0
 */
@RestController
public class MyDemoController {

    @ResponseBody
    @RequestMapping("/hello")
    public String hello() {
        return "hello world";
    }


    @GetMapping("/api/json/tasks")
    public ApiResult<Task> tasks(@Valid Task task) {
        return ApiResult.success(task);
    }


}
