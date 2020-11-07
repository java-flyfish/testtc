package com.test.tc.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(value = BindException.class)
    public Result hondleVaildException(BindException e){

        BindingResult result = e.getBindingResult();
        List<FieldError> fieldErrors = result.getFieldErrors();
        Map<String,String> map = new HashMap<>();
        fieldErrors.forEach((item)->{
            map.put(item.getField(),item.getDefaultMessage());
        });
        Result r = Result.fail("400001","参数异常");
        r.setData(map);
        return r;
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public Result hondleVaildException(MethodArgumentNotValidException e){

        BindingResult result = e.getBindingResult();
        List<FieldError> fieldErrors = result.getFieldErrors();
        Map<String,String> map = new HashMap<>();
        fieldErrors.forEach((item)->{
            map.put(item.getField(),item.getDefaultMessage());
        });
        Result r = Result.fail("400001","参数异常");
        r.setData(map);
        return r;
    }

    @ExceptionHandler(value = BaseAppException.class)
    public Result hondleException(BaseAppException e){
        log.error("系统异常:{}，异常类型：{},栈信息: ",e.getMessage(),e.getClass(),e);
        Result r = Result.fail(e.getCode(),e.getDesc());
        return r;
    }

    @ExceptionHandler(value = Throwable.class)
    public Result hondleException(Throwable throwable){
        log.error("系统异常:{}，异常类型：{},栈信息: ",throwable.getMessage(),throwable.getClass(),throwable);
        Result r = Result.fail("400001","网络异常");
        return r;
    }
}
