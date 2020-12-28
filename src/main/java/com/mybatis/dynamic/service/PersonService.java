package com.mybatis.dynamic.service;

import com.mybatis.dynamic.entity.LastName;
import com.mybatis.dynamic.mapper.PersonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author kaqiuzi
 */
@Service
public interface PersonService{

    /**
     *
     * @param id
     * @param firstName
     * @param lastName
     * @param birthDate
     * @param employed
     * @param occupation
     * @param addressId
     */
    void insert(int id, String firstName, LastName lastName, Date birthDate, Boolean employed,
             String occupation, int addressId);

    /**
     *
     * @param id
     */
    void delete(int id);





}
