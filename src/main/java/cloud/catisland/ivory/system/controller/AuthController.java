package cloud.catisland.ivory.system.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cloud.catisland.ivory.system.model.BO.RegBO;
import cloud.catisland.ivory.system.model.BO.ResultBean;

/**
 * @Author: Xy718
 * @Date: 2020-05-25 23:15:14
 * @LastEditors: Xy718
 * @LastEditTime: 2020-06-01 20:11:24
 */
@RestController
@RequestMapping("/auth")
public class AuthController {
    

    @PostMapping("/reg")
    public ResultBean reg(
        @RequestBody RegBO regBO
    ){
        return ResultBean.success(regBO);
    }
}