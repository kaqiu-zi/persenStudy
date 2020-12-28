package com.mybatis.dynamic.service.impl;

import com.mybatis.dynamic.entity.Human;
import com.mybatis.dynamic.entity.LastName;
import com.mybatis.dynamic.mapper.HumanMapper;
import com.mybatis.dynamic.service.HumanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDate;

/**
 * @author kaqiuzi
 */
@Service
public class HumanserviceImpl implements HumanService {

    @Resource
    private HumanMapper humanMapper;

    @Override
    public void insert(int id, String firstName, String lastName, LocalDate birthDate, String employed, String occupation, int addressId) {
        Human human = new Human();
        human.setId(id);
        human.setFirstName(firstName);
        human.setLastName(lastName);
        human.setBirthDate(birthDate);
        human.setEmployed(employed);
        human.setOccupation(occupation);
        human.setAddressId(addressId);
        humanMapper.insert(human);
    }

    @Override
    public boolean delete(int id) {
        return false;
    }
}
