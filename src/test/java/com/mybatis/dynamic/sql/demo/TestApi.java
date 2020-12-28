package com.mybatis.dynamic.sql.demo;

import com.mybatis.dynamic.mapper.HumanMapper;
import com.mybatis.dynamic.service.HumanService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.time.LocalDateTime;

@SpringBootTest
public class TestApi {

    @Resource
    private HumanService humanService;

    @Test
    public void testInsert(){
        humanService.insert(0,"1234","7890", LocalDate.now(),"005","996",10354);
        System.out.println("插入的humanid为" + 0);
    }


}
