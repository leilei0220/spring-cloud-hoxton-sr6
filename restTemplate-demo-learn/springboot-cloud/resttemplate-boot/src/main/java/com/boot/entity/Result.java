package com.boot.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author lei
 * @version 1.0
 * @date 2020/8/29 13:32
 * @desc
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Result {
    private String message;

    private Integer code;

    private Object data;

    public static Result success(Object data) {
        return Result.builder().message("请求成功").data(data).code(200).build();
    }

    public static Result failure() {
        return Result.builder().code(-1).message("请求失败").build();
    }
    public static Result failureMessage(String message) {
        return Result.builder().code(-1).message(message).build();
    }
}
