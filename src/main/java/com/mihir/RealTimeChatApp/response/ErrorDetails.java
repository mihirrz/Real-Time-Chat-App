package com.mihir.RealTimeChatApp.response;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ErrorDetails {

    private String fieldName; // The field where the error occurred
    private String message; // The error message for that field

    public ErrorDetails(String fieldName, String message) {
        this.fieldName = fieldName;
        this.message = message;
    }
}
