package com.network.common.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * {@link }TODO:需要删减，如果不为测试类则增加描述
 *
 * @author mingJie-Ou
 * @version 1.0 2021/3/8
 * @since 1.0.0
 */
@AllArgsConstructor
@Getter
public enum UserStatusEnum {
    DISABLE((byte) 0),
    INIT((byte) 1);

    private final byte value;
    private static final Map<Byte, UserStatusEnum> VALUE_MAP = Stream.of(UserStatusEnum.values()).collect(Collectors.toMap(UserStatusEnum::getValue, Function.identity()));

    /**
     * byte ->  enum
     *
     * @param value byte value
     * @return {@link  UserStatusEnum}
     */
    public static UserStatusEnum from(Byte value) {
        return null == value ? null : VALUE_MAP.get(value);
    }
}
