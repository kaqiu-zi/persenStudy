package com.network.rest.biz;

import com.network.rest.vo.UserEmailLoginRequest;
import com.network.rest.vo.UserRegisterRequest;
import com.network.rest.vo.UserResetRequest;

/**
 * 用户服务接口
 *
 * @author kaqiu
 * @version 1.0, 2021/3/4
 * @since 1.0.0
 */
public interface IUserBizService {
    /**
     * 用户注册
     *
     * @param request 请求
     */
    void register(UserRegisterRequest request);

    /**
     * 邮箱登陆
     *
     * @param request 请求
     */
    void emailLogin(UserEmailLoginRequest request);

    /**
     * 密码重置
     *
     * @param request 请求
     */
    void emailLogin(UserResetRequest request);

    /**
     * 获取公钥
     */
    void getPublicKey();
}
