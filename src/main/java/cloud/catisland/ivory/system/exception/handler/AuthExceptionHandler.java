package cloud.catisland.ivory.system.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import ch.qos.logback.core.encoder.EchoEncoder;
import cloud.catisland.ivory.system.exception.base.UserAlreadyRegisteredException;
import cloud.catisland.ivory.system.model.BO.ResultBean;

import java.util.List;

/**
 * 用户账户相关的异常捕获器
 * @Author: Xy718
 * @Date: 2020-06-05 13:58:18
 * @LastEditors: Xy718
 * @LastEditTime: 2020-06-10 00:16:07
 */
@RestControllerAdvice
public class AuthExceptionHandler {

    /**
     * 用于捕获账号已被注册的异常
     */
    @ExceptionHandler(UserAlreadyRegisteredException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResultBean uArdRegExpHendler(UserAlreadyRegisteredException exception) {
        return ResultBean.error(exception.getMessage());
    }

    /**
     * 同于捕获查找不到登录的用户的异常
     */
    @ExceptionHandler(LoginUserNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResultBean loginUserNotFoundException(LoginUserNotFoundException exception) {
        return ResultBean.error(exception.getMessage());
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
}