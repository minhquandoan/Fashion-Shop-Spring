package com.minhquan.common.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
public class ErrorResponse {
    private String id;
    private String errorMsg;
    private String errPath;
    private String endpoint;
}
