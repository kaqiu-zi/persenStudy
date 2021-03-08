package com.network.model.service.impl;

import com.network.model.dto.UserDTO;
import com.network.model.service.IUserService;
import org.springframework.stereotype.Repository;

/**
 * {@link } TODO:补充描述
 *
 * @author kaqiu
 * @version 1.0, 2021/3/4
 * @since 1.0.0
 */
@Repository
public class UserServiceImpl implements IUserService {

    /**
     * {@inheritDoc}
     */
    @Override
    public void add(UserDTO userDto) {
        // TODO: 2021/3/6  补充实现
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean existEmail(String email) {
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean existUsername(String username) {
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean existNickname(String nickname) {
        return false;
    }
}
