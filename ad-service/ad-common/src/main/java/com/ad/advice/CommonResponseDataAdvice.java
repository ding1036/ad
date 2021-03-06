package com.ad.advice;

import com.ad.annotation.IgnoreResponseAdvice;
import com.ad.vo.CommonResponse;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * @author created by emin on 2019/3/24
 **/
@RestControllerAdvice
public class CommonResponseDataAdvice implements ResponseBodyAdvice {
    @Override
    @SuppressWarnings("all")
    public boolean supports(MethodParameter methodParameter, Class aClass) {

        if (methodParameter.getDeclaringClass().isAnnotationPresent(IgnoreResponseAdvice.class)){
            return false;
        }

        if (methodParameter.getMethod().isAnnotationPresent(IgnoreResponseAdvice.class)){
            return false;
        }
        return true;
    }

    @Override
    @SuppressWarnings("all")
    public Object beforeBodyWrite(Object o,
                                  MethodParameter methodParameter,
                                  MediaType mediaType,
                                  Class aClass,
                                  ServerHttpRequest serverHttpRequest,
                                  ServerHttpResponse serverHttpResponse) {

        CommonResponse<Object> commonResponse = new CommonResponse<>(0,"");
        if (null == o){
            return commonResponse;
        } else if (o instanceof CommonResponse){
            commonResponse = (CommonResponse<Object>)o;
        } else {
            commonResponse.setData(o);
        }

        return commonResponse;
    }
}
