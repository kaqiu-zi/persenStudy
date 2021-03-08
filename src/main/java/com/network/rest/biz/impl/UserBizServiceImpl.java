package com.network.rest.biz.impl;

import com.network.common.CommonVO;
import com.network.common.ErrorCodeEnum;
import com.network.common.exception.BusinessException;
import com.network.common.pojo.UserStatusEnum;
import com.network.model.dto.UserDTO;
import com.network.model.service.IUserService;
import com.network.rest.biz.IUserBizService;
import com.network.rest.vo.UserEmailLoginRequest;
import com.network.rest.vo.UserRegisterRequest;
import com.network.rest.vo.UserResetRequest;
import org.apache.commons.lang3.tuple.Pair;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * {@link IUserBizService} impl
 *
 * @author kaqiu
 * @version 1.0, 2021/3/4
 * @since 1.0.0
 */
@Service
@RequiredArgsConstructor
public class UserBizServiceImpl implements IUserBizService {

    private final IUserService userService;

    /**
     * {@inheritDoc}
     */
    @Override
    public Pair<CommonVO, ErrorCodeEnum> register(UserRegisterRequest request) {
        // 检测邮箱、昵称是否重复
        if (userService.existEmail(request.getEmail())) {
            return Pair.of(null, ErrorCodeEnum.EMAIL_ALREADY_EXIST);
        }
        if (userService.existUsername(request.getUsername())) {
            return Pair.of(null, ErrorCodeEnum.USERNAME_ALREADY_EXIST);
        }
        // 检测邮箱验证码
        // 校验密码是否合法
        // TODO: 2021/3/8 私钥解密password，校验是否合法

        // 插入用户表
        final LocalDateTime now = LocalDateTime.now();
        final UserDTO userDto = UserDTO.builder()
            .username(request.getUsername())
            .email(request.getEmail())
            .password(request.getPassword())
            // TODO: 2021/3/8 头像是否使用默认文件等，需要敲定一下
            // TODO: 2021/3/8 敲定默认总容量
            // NOTE: 显示指定初始已使用0
            .footprint(0L)
            .status(UserStatusEnum.INIT)
            .created(now)
            .updated(now)
            .build();
        userService.add(userDto);
        return Pair.of(null, ErrorCodeEnum.OK);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Pair<CommonVO, ErrorCodeEnum> emailLogin(UserEmailLoginRequest request) {
        // TODO(mingJie-Ou): 2021/3/8 校验该邮箱今日的登陆次数限制
        // 校验邮箱是否存在
        if (userService.existEmail(request.getEmail())) {
            return Pair.of(null, ErrorCodeEnum.EMAIL_NOT_EXIST);
        }
        // 校验密码是否正确
        // TODO: 2021/3/8 构建加密算法后，对密码进行比较。
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Pair<CommonVO, ErrorCodeEnum> reset(UserResetRequest request) {
        // 校验邮箱是否存在
        // 校验密码是否合法
        // 更新用户表
        // TODO: 2021/3/6  补充实现
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Pair<CommonVO, ErrorCodeEnum> getPublicKey() {
        // TODO: 2021/3/6  补充实现
        // 配置yaml文件进行实现。
        return null;
    }
}
