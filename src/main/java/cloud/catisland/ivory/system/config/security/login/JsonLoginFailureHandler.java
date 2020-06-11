package cloud.catisland.ivory.system.config.security.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import cloud.catisland.ivory.system.model.BO.ResultBean;

/**
 * Json登陆失败处理程序
 * @Author: Xy718
 * @Date: 2020-05-24 23:28:06
 * @LastEditors: Xy718
 * @LastEditTime: 2020-06-04 13:52:09
 */
public class JsonLoginFailureHandler implements AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(
        HttpServletRequest request
        , HttpServletResponse response
        ,AuthenticationException exception
            ) throws IOException, ServletException {
        System.out.println(request.getRemoteAddr()+" UNAUTHORIZED");
        // response.setStatus(HttpStatus.UNAUTHORIZED.value());
        response.getWriter()
            .write(JSON.toJSONString(ResultBean.error("登陆失败，用户名或密码不正确")));
    }   
}