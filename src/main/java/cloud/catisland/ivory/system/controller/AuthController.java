package cloud.catisland.ivory.system.controller;

import java.io.Console;
import java.util.Optional;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cloud.catisland.ivory.common.dao.model.User;
import cloud.catisland.ivory.common.dao.model.enums.UserRegStatus;
import cloud.catisland.ivory.common.service.UserService;
import cloud.catisland.ivory.system.exception.base.UserAlreadyRegisteredException;
import cloud.catisland.ivory.system.model.BO.RegBO;
import cloud.catisland.ivory.system.model.BO.ResultBean;

/**
 * @Author: Xy718
 * @Date: 2020-05-25 23:15:14
 * @LastEditors: Xy718
 * @LastEditTime: 2020-06-05 15:18:08
 */
@Validated
@RestController
@RequestMapping("/auth")
public class AuthController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthController.class);

    @Resource
    UserService uService;

    @PostMapping("/reg")
    public ResultBean reg(
        @Valid @RequestBody RegBO regBO
        ) throws UserAlreadyRegisteredException {

        LOGGER.info(uService.checkUserRegedByUsername(regBO.getUsername()).name());
        if(uService.checkUserRegedByUsername(regBO.getUsername()).equals(UserRegStatus.Registed)){
            throw new UserAlreadyRegisteredException(regBO);
        }
        Optional<User> u = uService.registUser(regBO);
        return u.isPresent()?
            ResultBean.success("注册成功！",u.get()):
            ResultBean.error("注册失败！Save错误");
            
    }
    
}