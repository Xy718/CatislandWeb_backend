package cloud.catisland.ivory.common.dao.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang3.RandomUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import cloud.catisland.ivory.system.model.BO.RegBO;
import cn.hutool.core.util.RandomUtil;
import lombok.Data;

/**
 * 用户类/DO
 * @author Xy718
 * 
 */
//TODO 记得把一些Unique字段弄一下
@Data
@Entity
@Table(name="user")
public class User {
    //用户ID
    @Id
    @GeneratedValue
    private long uid;
    //用户名
    @Column(name="user_name",nullable = false, unique = true)
    private String userName;
    //昵称
    @Column(name="nick_name",nullable = false)
    private String nickName;
    //用户游戏账号
    @Column(name="user_game_id",nullable = false)
    private String userGameID="";
    //用户游戏UUID
    @Column(name="user_game_uuid",nullable = false)
    private String userGameUUID="";
    //手机号
    @Column(name="phone",nullable = false)//, unique = true
    private String phone="";
    //邮箱
    @Column(name="email",nullable = false)//, unique = true
    private String email="";
    //密码(BCrypt加密)
    @Column(name="password",nullable = false)
    private String password;
    //密码加密盐
    @Column(name="password_salt",nullable = false)
    private String passwordSalt="";

    /**
     * 根据传入的RegBO创建一个待保存的新用户对象
     */
    public User(RegBO regBO){
        this.userName=regBO.getUsername();
        //生成密码盐
        this.passwordSalt=RandomUtil.randomString(8);
        //TODO 密码BCrypt加密
        // this.password=regBO.getPassword();
        this.password=new BCryptPasswordEncoder().encode(this.passwordSalt+regBO.getPassword());
        this.nickName=this.userName;
    }

    /**
     * 不带参的构造函数，用于支持Hibernate反射创造对象
     */
    public User(){}
}