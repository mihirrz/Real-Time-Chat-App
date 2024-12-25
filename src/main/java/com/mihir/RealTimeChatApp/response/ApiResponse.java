package com.mihir.RealTimeChatApp.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL) // Excludes null values from the response
public class ApiResponse<T> {

    private boolean success; // Indicates if the operation was successful
    private String message;  // A custom message for the client
    private T data; // The data (optional) associated with the response

    public ApiResponse(boolean success, String message, T data) {
        this.success = success;
        this.message = message;
        this.data = data;
    }

    // Static factory method for success responses
    public static <T> ApiResponse<T> success(String message, T data) {
        return new ApiResponse<>(true, message, data);
    }
//
    // Static factory method for success responses without data
    public static <T> ApiResponse<T> success(String message) {
        return new ApiResponse<>(true, message, null);
    }

    // Static factory method for failure responses with optional data
    public static <T> ApiResponse<T> failure(String message, T data) {
        return new ApiResponse<>(false, message, data);
    }
//
    // Static factory method for failure responses without data
    public static <T> ApiResponse<T> failure(String message) {
        return new ApiResponse<>(false, message, null);
    }
}
