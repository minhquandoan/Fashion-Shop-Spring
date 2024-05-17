package com.minhquan.common.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.minhquan.common.exception.custom.AppInternalException;
import com.minhquan.common.response.ErrorResponse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    public static List<Map<String, String>> convertStackTrace(StackTraceElement[] stacktrace) {
        List<Map<String, String>> listTrace = new ArrayList<>();
        for (StackTraceElement trace : stacktrace) {
            Map<String, String> tracerMap = new HashMap<>();
            tracerMap.put("ClassName", trace.getClassName());
            tracerMap.put("FileName", trace.getFileName());
            tracerMap.put("MethodName", trace.getMethodName());
            tracerMap.put("CodeLine", String.valueOf(trace.getLineNumber()));
            listTrace.add(tracerMap);
        }
        return listTrace;
    }
    
    @ExceptionHandler({AppInternalException.class})
    public ErrorResponse handleInternalException(AppInternalException ex, WebRequest wRequest) {

        return ErrorResponse.builder()
                            .id("00000")
                            .errorMsg(ex.getDescription())
                            .errPath(convertStackTrace(ex.getStackTrace()).toString())
                            .endpoint(wRequest.getDescription(false))
                            .build();
    }
}
