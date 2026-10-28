package com.example.cruddto.dto;

import java.time.LocalDateTime;
import java.util.Map;

public class VlidationExceptionResponsedto {

    private LocalDateTime timestamp;
    private int statuscode;
    private String message;
    private String error;
    private String path;
    private Map<String,String> fieldErrors;


    public VlidationExceptionResponsedto(LocalDateTime timestamp, int statuscode, String message, String error, String path, Map<String, String> fieldErrors) {
        this.timestamp = timestamp;
        this.statuscode = statuscode;
        this.message = message;
        this.error = error;
        this.path = path;
        this.fieldErrors = fieldErrors;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public int getStatuscode() {
        return statuscode;
    }

    public void setStatuscode(int statuscode) {
        this.statuscode = statuscode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Map<String, String> getFieldError() {
        return fieldErrors;
    }

    public void setFieldError(Map<String, String> fieldErrors) {
        this.fieldErrors = fieldErrors;
    }
}
