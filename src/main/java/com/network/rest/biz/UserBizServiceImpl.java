package com.network.rest.biz;

import com.network.rest.vo.UserEmailLoginRequest;
import com.network.rest.vo.UserRegisterRequest;
import com.network.rest.vo.UserResetRequest;
import org.springframework.stereotype.Service;

/**
 * {@link } TODO:补充描述
 *
 * @author kaqiu
 * @version 1.0, 2021/3/4
 * @since 1.0.0
 */
@Service
public class UserBizServiceImpl implements IUserBizService {

    /**
     * {@inheritDoc}
     */
    @Override
    public void register(UserRegisterRequest request) {
        // TODO: 2021/3/6  补充实现
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void emailLogin(UserEmailLoginRequest request) {
        // TODO: 2021/3/6  补充实现
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void emailLogin(UserResetRequest request) {
        // TODO: 2021/3/6  补充实现
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void getPublicKey() {
        // TODO: 2021/3/6  补充实现
    }
}
