package com.network.model.dto;

import com.network.common.pojo.UserStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * user dto
 *
 * @author kaqiu
 * @version 1.0, 2021/3/7
 * @since 1.0.0
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserDTO {
    /** id */
    private Integer id;
    /** 用户名 */
    private String username;
    /** 邮箱 */
    private String email;
    /** 密码 */
    private String password;
    /** 昵称 */
    private String nickname;
    /** 头像对应的文件id */
    private Long avatarFileId;
    /** 头像 */
    private String avatarUrl;
    /** 总容量 */
    private Long capacity;
    /** 占用空间 */
    private Long footprint;
    /** 状态 */
    private UserStatusEnum status;
    /** 创建时间 */
    private LocalDateTime created;
    /** 更新时间 */
    private LocalDateTime updated;
}
