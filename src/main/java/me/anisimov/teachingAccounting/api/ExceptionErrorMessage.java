package me.anisimov.teachingAccounting.api;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
public class ExceptionErrorMessage extends RuntimeException{

    private Integer code;
    private String errorMessage;
    private ApiResponse data;

    public ExceptionErrorMessage(Integer code, String errorMessage, ApiResponse data) {
        super("code: " + code + "/n errorMessage: " + errorMessage + "/n data: " + data);
        this.code = code;
        this.errorMessage = errorMessage;
        this.data = data;
    }

//     public InsufficientItemException(Throwable cause, Integer code, String errorMessage, ApiResponse data) {
//        super("code: " + code + "/n errorMessage: " + errorMessage + "/n data: " + data, cause);
//        this.code = code;
//        this.errorMessage = errorMessage;
//        this.data = data;
//
//    }

}
