package cloud.catisland.ivory.system.config.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import cloud.catisland.ivory.common.service.JwtUserService;

/**
 * 登陆成功的处理程序
 */
public class JsonLoginSuccessHandler implements AuthenticationSuccessHandler {
    
    private JwtUserService jwtUserService;
    
    public JsonLoginSuccessHandler(JwtUserService jwtUserService) {
        this.jwtUserService = jwtUserService;
    }

    @Override
    public void onAuthenticationSuccess(
        HttpServletRequest request
        ,HttpServletResponse response
        ,Authentication authentication
        ) throws IOException, ServletException {
        //生成token，并把token加密相关信息缓存
        String token = jwtUserService.saveUserLoginInfo((UserDetails)authentication.getPrincipal());
        response.setHeader("Authorization", token);
    }
    
}