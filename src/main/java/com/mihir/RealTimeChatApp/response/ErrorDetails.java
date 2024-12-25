package com.mihir.RealTimeChatApp.response;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ErrorDetails {

    private String fieldName; // The field where the error occurred
    private String message; // The error message for that field

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ErrorDetails(String fieldName, String message) {
        this.fieldName = fieldName;
        this.message = message;
    }
}
