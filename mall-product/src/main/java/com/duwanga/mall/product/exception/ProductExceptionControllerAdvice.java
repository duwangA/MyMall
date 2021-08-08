package com.duwanga.mall.product.exception;

import com.duwanga.common.exception.BizCodeEnume;
import com.duwanga.common.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

/**
 * 统一处理异常
 */
@Slf4j
@RestControllerAdvice(basePackages = "com.duwanga.mall.product.controller")
public class ProductExceptionControllerAdvice {

    /**
     * 注解表示能处理什么类型的异常
     */
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public R handleValidException(MethodArgumentNotValidException e){
        log.error("数据校验出错：{},异常类型：{}",e.getMessage(),e.getClass());
        Map<String, String> map = new HashMap<>();
        e.getBindingResult().getFieldErrors().forEach((item)->{
                //获取到错误提示
                String message = item.getDefaultMessage();
                //获取到错误字段名
                String field = item.getField();
                map.put(field,message);
        });
        return R.error(BizCodeEnume.VALID_EXCEPTION.getCode(),BizCodeEnume.VALID_EXCEPTION.getMsg()).put("data",map);
    }

//    @ExceptionHandler(value = Throwable.class)
//    public R handleException(Throwable e){
//        return R.error(BizCodeEnume.UNKNOW_EXCEPTION.getCode(),BizCodeEnume.UNKNOW_EXCEPTION.getMsg());
//    }
}
