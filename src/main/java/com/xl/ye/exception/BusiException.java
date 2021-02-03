package com.xl.ye.exception;


import lombok.Data;

@Data
public class BusiException extends RuntimeException {

    private String errorCode;
    private String errorMsg;

    public BusiException(String errorCode, String errorMsg){
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }


}
