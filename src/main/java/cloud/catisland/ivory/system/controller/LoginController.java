package cloud.catisland.ivory.system.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cloud.catisland.ivory.system.model.BO.RegBO;
import cloud.catisland.ivory.system.model.BO.ResultBean;

@RestController
@RequestMapping("/login")
public class LoginController {
    

    @PostMapping("/reg")
    public ResultBean reg(
        @RequestBody RegBO regBO
    ){
        return ResultBean.success(regBO);
    }
}