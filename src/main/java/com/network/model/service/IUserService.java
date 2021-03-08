package com.network.model.service;

import com.network.model.dto.UserDTO;

/**
 * {@link } 通用service
 *
 * @author kaqiu
 * @version 1.0, 2021/3/4
 * @since 1.0.0
 */
public interface IUserService {

    /**
     * 添加一个新用户
     */
    void add(UserDTO userDto);

    /**
     * 判断email 是否存在重复
     *
     * @param email 邮箱
     * @return 存在 -> true， 不存在 -> false
     */
    boolean existEmail(String email);

    /**
     * 判断username 是否存在重复
     *
     * @param username 用户名
     * @return 存在 -> true， 不存在 -> false
     */
    boolean existUsername(String username);

    /**
     * 判断nickname 是否存在重复
     *
     * @param nickname 昵称
     * @return 存在 -> true， 不存在 -> false
     */
    boolean existNickname(String nickname);
}
