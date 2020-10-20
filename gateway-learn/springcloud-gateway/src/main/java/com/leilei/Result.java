package com.leilei;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author lei
 * @version 1.0
 * @date 2020/10/20 13:32
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
    public static Result success(String message,Object data) {
        return Result.builder().message(message).data(data).code(200).build();
    }
    public static Result failure() {
        return Result.builder().code(-1).message("请求失败").build();
    }
    public static Result failure(String message,Integer code) {
        return Result.builder().code(code).message(message).data(null).build();
    }
    public static Result failure(String message) {
        return Result.builder().code(-1).message(message).build();
    }
}
