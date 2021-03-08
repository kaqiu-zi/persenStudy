package com.network.rest.biz;

import com.network.common.CommonVO;
import com.network.common.ErrorCodeEnum;
import com.network.rest.vo.UserEmailLoginRequest;
import com.network.rest.vo.UserRegisterRequest;
import com.network.rest.vo.UserResetRequest;
import org.apache.commons.lang3.tuple.Pair;

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
    Pair<CommonVO, ErrorCodeEnum> register(UserRegisterRequest request);

    /**
     * 邮箱登陆
     *
     * @param request 请求
     */
    Pair<CommonVO, ErrorCodeEnum> emailLogin(UserEmailLoginRequest request);

    /**
     * 密码重置
     *
     * @param request 请求
     */
    Pair<CommonVO, ErrorCodeEnum> reset(UserResetRequest request);

    /**
     * 获取公钥
     */
    Pair<CommonVO, ErrorCodeEnum> getPublicKey();
}
