package com.network.rest.controller;

import com.network.common.ApiResult;
import com.network.common.CommonRequest;
import com.network.common.CommonVO;
import com.network.rest.biz.IUserBizService;
import com.network.rest.vo.UserEmailLoginRequest;
import com.network.rest.vo.UserLoginVO;
import com.network.rest.vo.UserRegisterRequest;
import com.network.rest.vo.UserResetRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.Executor;

/**
 * 用户控制器
 *
 * @author kaqiu
 * @version 1.0, 2021/3/6
 * @since 1.0.0
 */
@Api(value = "用户服务",
    tags = "用户服务",
    consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
    produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
@ResponseBody
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private Executor executorService;
    private final MessageSource messageSource;
    private final IUserBizService userBizService;

    @ApiOperation(value = "邮箱注册")
    @PutMapping("/register")
    public CompletionStage<ApiResult<Void>> emailRegister(UserRegisterRequest request) {
        return CompletableFuture.supplyAsync(ApiResult::success);
    }

    @ApiOperation(value = "邮箱登陆")
    @GetMapping("/email")
    public CompletionStage<ApiResult<UserLoginVO>> emailLogin(UserEmailLoginRequest request) {
        return CompletableFuture.supplyAsync(() ->
            ApiResult.success(new UserLoginVO()), this.executorService);
    }

    @ApiOperation(value = "密码重置")
    @PostMapping
    public CompletionStage<ApiResult<Void>> reset(@ApiParam @Valid UserResetRequest request) {
        return CompletableFuture.supplyAsync(ApiResult::success);
    }

    @ApiOperation(value = "获取公钥")
    @GetMapping("/key")
    public CompletionStage<ApiResult<String>> getPublicKey() {
        return CompletableFuture.supplyAsync(() -> ApiResult.success(""), this.executorService);
    }
}
