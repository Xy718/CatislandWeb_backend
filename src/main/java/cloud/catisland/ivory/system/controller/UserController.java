package cloud.catisland.ivory.system.controller;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cloud.catisland.ivory.system.model.BO.ResultBean;
import cloud.catisland.ivory.system.model.BO.UserInfoBO;
import cloud.catisland.ivory.common.dao.model.User;
import cloud.catisland.ivory.common.service.TopicService;

@RestController
@RequestMapping("/user")
public class UserController {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
    @Resource
    private TopicService topicService;

    @GetMapping("/userinfo")
    public ResultBean getuserinfo(

    ){
        User user=(User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        
        return ResultBean.success(new UserInfoBO());
    }
}