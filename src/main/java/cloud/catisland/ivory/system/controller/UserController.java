package cloud.catisland.ivory.system.controller;

import java.util.Optional;

import javax.annotation.Resource;
import javax.validation.constraints.NotEmpty;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cloud.catisland.ivory.system.model.BO.ResultBean;
import cloud.catisland.ivory.system.model.BO.UserInfoBO;
import cloud.catisland.ivory.common.dao.model.User;
import cloud.catisland.ivory.common.service.TopicService;
import cloud.catisland.ivory.common.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
    @Resource
    private UserService userService;

    /**
     * 获取登录用户自身的信息
     */
    @GetMapping
    public ResultBean getuserinfo(

    ){
        Object user = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        
        return ResultBean.success(user);
    }

    /**
     * 通过uid或者username获取其他用户的信息
     */
    @GetMapping("/{param}")
    public ResultBean getuserinfoByIDNAME(
        @RequestParam("param")
        @NotEmpty("该参数不允许为空") String param
    ){
        User
        SecurityContext  user = SecurityContextHolder.getContext();
        
        return ResultBean.success(user);
    }

    @PutMapping
    public ResponseEntity<UserInfoBO> updateInfo(
        @RequestBody UserInfoBO user
        ) {
        //拿出已有用户
        Optional<User> existingItemOptional = userService.findById(user.getUid());
        if (existingItemOptional.isPresent()) {//如果存在
            User existingItem = existingItemOptional.get();
            existingItem.mergeFromBO(user);
            return new ResponseEntity<UserInfoBO>(new UserInfoBO(userService.save(existingItem)), HttpStatus.OK);
        } else {
            throw new UsernameNotFoundException("该用户不存在");
        }
    }
    
}