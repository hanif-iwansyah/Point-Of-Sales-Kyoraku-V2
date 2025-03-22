package com.example.kyoraku.model.response;

import java.time.Instant;

public class BaseResponse<T> {
    private String timestamp;
    private int status;
    private String error;
    private String message;
    private T data;

    public BaseResponse(int status, String error, String message, T data) {
        this.timestamp = Instant.now().toString();
        this.status = status;
        this.error = error;
        this.message = message;
        this.data = data;
    }

    public BaseResponse(int status, String message, T data) {
        this.timestamp = Instant.now().toString();
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
