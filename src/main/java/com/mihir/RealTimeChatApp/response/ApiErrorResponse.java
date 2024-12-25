package com.mihir.RealTimeChatApp.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiErrorResponse {

    private String errorCode; // Unique error code
    private String errorMessage; // Description of the error
    private Object details; // Additional error details (optional)

}
