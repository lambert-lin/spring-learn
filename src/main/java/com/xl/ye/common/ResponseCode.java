package com.xl.ye.common;


import lombok.Getter;

@Getter
public enum ResponseCode {

    SUCCESS("1", "响应成功"),
    ERROR("-1", "响应失败")
    ;

    private String code;
    private String msg;

    ResponseCode(String code, String msg){
        this.code = code;
        this.msg = msg;
    }

}
