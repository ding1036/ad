package com.ad.advice;

import com.ad.exception.AdException;
import com.ad.vo.CommonResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * @author created by emin on 2019/3/24
 **/
@RestControllerAdvice
public class GlobalExceptionAdvice {

    @ExceptionHandler(value = AdException.class)
    public CommonResponse<String> handleAdException(HttpServletRequest request,
                                                    AdException ex){
            CommonResponse<String> commonResponse = new CommonResponse<>(-1,"error");
            commonResponse.setData(ex.getMessage());
            return commonResponse;
    }
}
