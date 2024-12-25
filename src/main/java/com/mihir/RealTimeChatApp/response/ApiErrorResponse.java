package com.mihir.RealTimeChatApp.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class ApiErrorResponse {

    private String errorCode; // Unique error code
    private String errorMessage; // Description of the error
    private Object details; // Additional error details (optional)

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public Object getDetails() {
        return details;
    }

    public void setDetails(Object details) {
        this.details = details;
    }

    public ApiErrorResponse(String errorCode, String errorMessage, Object details) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.details = details;
    }

}
