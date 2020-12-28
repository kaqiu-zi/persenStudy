package com.mybatis.dynamic.service;


import com.mybatis.dynamic.entity.LastName;

import java.time.LocalDate;


public interface HumanService {

    /**
     * 插入一个新人类，需要其他的各种信息
     * @param id
     * @param firstName
     * @param lastName
     * @param birthDate
     * @param employed
     * @param occupation
     * @param addressId
     */
    void insert(int id, String firstName, String lastName, LocalDate birthDate, String employed,
                String occupation, int addressId);

    boolean delete(int id);

}
