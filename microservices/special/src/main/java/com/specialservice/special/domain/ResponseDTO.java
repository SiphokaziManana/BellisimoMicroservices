package com.specialservice.special.domain;

/**
 * Created by siphokazi on 2017/09/14.
 */
public class ResponseDTO {

    private String message;

    public ResponseDTO(String message){
        this.message = message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
