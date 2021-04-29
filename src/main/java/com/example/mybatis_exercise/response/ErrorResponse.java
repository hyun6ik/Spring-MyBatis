package com.example.mybatis_exercise.response;

public class ErrorResponse {

    private String result;

    public ErrorResponse(String result) {
        this.result = result;
    }

    public static ErrorResponse of(String result){
        return new ErrorResponse(result);
    }
}
