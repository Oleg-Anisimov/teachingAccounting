package me.anisimov.teachingAccounting.api;


import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

//    @Override
//    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
//        List<String> errorList = ex
//                .getBindingResult()
//                .getFieldErrors()
//                .stream()
//                .map(fieldError -> fieldError.getDefaultMessage())
//                .collect(Collectors.toList());
//        ApiResponse error = ApiResponse.error("Error faced! For more info look at data", errorList);
//        return handleExceptionInternal(ex, error, headers, HttpStatus.BAD_GATEWAY, request);
//    }

//    @ExceptionHandler({Exception.class})
//    public ResponseEntity<ApiResponse> ExceptionErrorMessage(Exception e) {
//        log.error(e.getMessage());
//        log.error(e.getCause().toString());
//        return ResponseEntity.ok(ApiResponse.error(e.getMessage()));
//    }

}
