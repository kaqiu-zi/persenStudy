package com.network.common;

import com.network.common.ApiResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.Executor;

/**
 * 通用控制器
 *
 * @author kaqiu
 * @version 1.0, 2021/3/4
 * @since 1.0.0
 */
@Api(value = "通用",
    tags = "通用",
    consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
    produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
@ResponseBody
@RequestMapping("/common")
@RequiredArgsConstructor
public class CommonController {
    private Executor executorService;
    private final MessageSource messageSource;

    @ApiOperation(value = "getMapping")
    @GetMapping
    public CompletionStage<ApiResult<List<CommonVO>>> get() {
        return CompletableFuture.supplyAsync(() ->
            ApiResult.success(Collections.singletonList(new CommonVO())), this.executorService);
    }

    @ApiOperation(value = "postMapping")
    @PostMapping
    public CompletionStage<ApiResult<Void>> queryTaskShowRecommendations(@ApiParam @Valid CommonRequest request) {
        return CompletableFuture.supplyAsync(ApiResult::success);
    }

    @ApiOperation(value = "PutMapping")
    @PutMapping("/{userId:.+}")
    public CompletionStage<ApiResult<Void>> followTopic(@PathVariable("userId") Long userId) {
        return CompletableFuture.supplyAsync(ApiResult::success);
    }

    @ApiOperation(value = "DeleteMapping")
    @DeleteMapping
    public CompletionStage<ApiResult<List<Void>>> queryTopicHots(@ApiParam @Valid CommonRequest request) {
        return CompletableFuture.supplyAsync(ApiResult::success);
    }
}
