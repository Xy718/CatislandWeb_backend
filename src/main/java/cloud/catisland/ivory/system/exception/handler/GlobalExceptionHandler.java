package cloud.catisland.ivory.system.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import cloud.catisland.ivory.system.exception.base.UserNickNameNotFoundException;
import cloud.catisland.ivory.system.exception.base.UserPassErrorException;
import cloud.catisland.ivory.system.model.BO.ResultBean;

import java.util.List;

/**
 * 全局异常捕获，一般捕获一些较常见的异常
 * @Author: Xy718
 * @Date: 2020-06-05 13:58:18
 * @LastEditors: Xy718
 * @LastEditTime: 2020-06-10 00:28:02
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 用于捕获Controller接口传入字段校验不通过的异常
     * @param exception
     * @return ResultBean
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResultBean MethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        List<ObjectError> allErrors=exception.getBindingResult().getAllErrors();

        return ResultBean.error(allErrors.get(0).getDefaultMessage());
    }
    
    /**
     * 用于捕获用户名密码错误的异常
     * @param exception
     * @return ResultBean
     */
    @ExceptionHandler(UserPassErrorException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResultBean UserPassErrorException(UserPassErrorException exception) {
        return ResultBean.error(exception.getMessage());
    }

    /**
     * 用于捕获用户信息时通过昵称获取不到的异常
     * @param exception
     * @return ResultBean
     */
    @ExceptionHandler(UserNickNameNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResultBean UserNickNameNotFoundException(UserNickNameNotFoundException exception) {
        return ResultBean.error(exception.getMessage());
    }
}