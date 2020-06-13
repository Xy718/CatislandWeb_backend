package cloud.catisland.ivory.system.controller;

import java.util.Optional;

import javax.annotation.Resource;
import javax.validation.Valid;
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
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cloud.catisland.ivory.system.exception.base.UserNickNameNotFoundException;
import cloud.catisland.ivory.system.model.BO.ResultBean;
import cloud.catisland.ivory.system.model.BO.UserInfoBO;
import cloud.catisland.ivory.common.dao.model.User;
import cloud.catisland.ivory.common.service.TopicService;
import cloud.catisland.ivory.common.service.UserService;

@Validated
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

    ) {
        Object user = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        return ResultBean.success(user);
    }

    /**
     * 通过uid或者username获取其他用户的信息
     * 
     * @throws UserNickNameNotFoundException
     */
    @GetMapping("/{nickname}")
    public ResultBean getuserinfoByNickName(
            @RequestParam("nickname") 
            @Valid @NotEmpty(message = "该参数不允许为空") String nickname)
            throws UserNickNameNotFoundException {
        User user=userService.findByNickName(nickname);
        
        return ResultBean.success(user);
    }

    /**
     * 更新登录用户自身的信息<br>
     * 如果未登录抛出异常
     */
    @PutMapping
    public ResponseEntity<UserInfoBO> updateInfo(
        @RequestBody UserInfoBO user
        ) {
        //先获取登录用户的ID

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

    //TODO 修改密码的接口

    //TODO 关注某一个好哥哥
    
}