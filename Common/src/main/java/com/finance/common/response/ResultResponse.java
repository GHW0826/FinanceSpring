package com.finance.common.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResultResponse<T> {
    private boolean success;
    private String message;
    private T data;

    public static <T> ResultResponse<T> success(T data) {
        return new ResultResponse<>(true, null, data);
    }

    public static <T> ResultResponse<T> fail(String message) {
        return new ResultResponse<>(false, message, null);
    }
}