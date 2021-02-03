package com.xl.ye.aspect;


import com.xl.ye.common.RespResult;
import com.xl.ye.common.ResponseCode;
import com.xl.ye.exception.BusiException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerExceptionHandler {

    private Logger LOG = LoggerFactory.getLogger(ControllerExceptionHandler.class);
    /**
     * 处理未捕获的Exception
     * @param e 异常
     * @return 统一响应体
     */
    @ExceptionHandler(Exception.class)
    public RespResult handleException(Exception e){
        LOG.info("=========golabl exception handler ====== excetipn {}",e.getClass());
        return RespResult.error();
    }

    /**
     * 处理未捕获的RuntimeException
     * @param e 运行时异常
     * @return 统一响应体
     */
    @ExceptionHandler(RuntimeException.class)
    public RespResult handleRuntimeException(RuntimeException e){
        LOG.info("=========golabl exception handler ====== excetipn {}",e.getClass());
        return RespResult.error();
    }

    /**
     * 处理业务异常BaseException
     * @param e 业务异常
     * @return 统一响应体
     */
    @ExceptionHandler(BusiException.class)
    public RespResult handleBaseException(BusiException e){
        LOG.info("=========golabl exception handler ====busiException== excetipn");

        return RespResult.error(e);
    }



}
