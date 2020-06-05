package cloud.catisland.ivory.system.exception;

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
 * @LastEditTime: 2020-06-05 17:50:29
 */
@RestControllerAdvice
public class AuthException {

    @ExceptionHandler(UserAlreadyRegisteredException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResultBean uArdRegExpHendler(UserAlreadyRegisteredException exception) {
        return ResultBean.error(exception.getMessage());
    }
}