package com.xl.ye.common;


import com.xl.ye.exception.BusiException;
import lombok.Getter;


@Getter
public class RespResult<T> {


    // resp code
    private String code;

    // resp message
    private String msg;

    // resp data
    private T data;

    private RespResult(ResponseCode responseCode, T data){
        this.code = responseCode.getCode();
        this.msg = responseCode.getMsg();
        this.data = data;
    }


    //自定义错误信息
    private RespResult(String code, String msg){
        this.code = code;
        this.msg = msg;
    }


    // 成功返回，无返回数据
    public static RespResult success(){
        return new RespResult(ResponseCode.SUCCESS, null);
    }

    //带有响应数据的成功返回
    public static <T> RespResult<T> success(T data){
        return new RespResult(ResponseCode.SUCCESS, data);
    }


    // 成功返回，无返回数据
    public static RespResult error(){
        return new RespResult(ResponseCode.ERROR, null);
    }

    //带有响应数据的错误返回
    public static <T> RespResult<T> error(T data){
        return new RespResult(ResponseCode.ERROR, data);
    }

    //带有响应数据的错误返回，且自定义响应message
    public static <T> RespResult<T> error(BusiException e){
        return new RespResult(e.getErrorCode(), e.getErrorMsg());
    }


    @Override
    public String toString() {
        return "{" +
                "\"code\":" + code +
                ", \"msg\":'" + msg + '\'' +
                ", \"data\":" + data +
                '}';
    }
}
