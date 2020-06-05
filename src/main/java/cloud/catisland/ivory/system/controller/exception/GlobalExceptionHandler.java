package cloud.catisland.ivory.system.controller.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import cloud.catisland.ivory.system.model.BO.ResultBean;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;
import java.util.Set;

/**
 * 全局异常捕获，一般捕获一些较常见的异常
 * @Author: Xy718
 * @Date: 2020-06-05 13:58:18
 * @LastEditors: Xy718
 * @LastEditTime: 2020-06-05 16:24:58
 */

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ValidationException.class)
    // @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResultBean handle(ValidationException exception) {
        if(exception instanceof ConstraintViolationException){
            ConstraintViolationException exs = (ConstraintViolationException) exception;

            Set<ConstraintViolation<?>> violations = exs.getConstraintViolations();
            for (ConstraintViolation<?> item : violations) {
                //打印验证不通过的信息
                System.out.println(item.getMessage());
            }
        }
        return ResultBean.error(exception.getMessage()) ;
    }
}