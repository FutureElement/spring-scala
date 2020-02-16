package com.learn.scala.springscala.controller.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ApiResult<T> {
    private Integer code;
    private String msg;
    private T data;

    public static <T> ApiResult<T> success() {
        return success(null);
    }

    public static <T> ApiResult<T> success(T data) {
        return new ApiResult<>(HttpStatus.OK.value(), "成功", data);
    }

    public static <T> ApiResult<T> error() {
        return error(HttpStatus.INTERNAL_SERVER_ERROR.value(), "失败");
    }

    public static <T> ApiResult<T> error(int code, String msg) {
        return new ApiResult<>(code, msg, null);
    }
}
