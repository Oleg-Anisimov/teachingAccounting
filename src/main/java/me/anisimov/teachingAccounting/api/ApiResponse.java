package me.anisimov.teachingAccounting.api;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse<T> {

    private T data = null;
    private ApiResponseStatus status;
    private String error;

    public static ApiResponse ok() {
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setStatus(ApiResponseStatus.OK);
        return apiResponse;
    }

    public static <T> ApiResponse<T> ok(T data) {
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setData(data);
        apiResponse.setStatus(ApiResponseStatus.OK);
        return apiResponse;
    }

    public static ApiResponse error(String errorMsg) {
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setStatus(ApiResponseStatus.ERROR);
        apiResponse.setError(errorMsg);
        return apiResponse;
    }

    public static <T> ApiResponse<T> error(String errorMsg, T data) {
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setStatus(ApiResponseStatus.ERROR);
        apiResponse.setError(errorMsg);
        apiResponse.setData(data);
        return apiResponse;
    }

}
