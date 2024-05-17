package com.minhquan.common.exception.custom;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AppInternalException extends RuntimeException {
    private int code;
    private String description;
}
