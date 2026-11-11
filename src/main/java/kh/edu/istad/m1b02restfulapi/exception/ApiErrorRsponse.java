package kh.edu.istad.m1b02restfulapi.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;

@Builder
public record ApiErrorRsponse<T>(
        String message,
        String code,

        @JsonInclude(JsonInclude.Include.NON_NULL)
        T data
) {
}
