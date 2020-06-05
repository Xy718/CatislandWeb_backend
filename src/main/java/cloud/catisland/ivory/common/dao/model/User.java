package cloud.catisland.ivory.common.dao.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

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
    //用户游戏账号
    @Column(name="user_game_id",nullable = false)
    private String userGameID;
    //用户游戏UUID
    @Column(name="user_game_uuid",nullable = false)
    private String userGameUUID;
    //手机号
    @Column(name="phone",nullable = false, unique = true)
    private String phone;
    //邮箱
    @Column(name="email",nullable = false, unique = true)
    private String email;
    //密码(BCrypt加密)
    @Column(name="password",nullable = false)
    private String password;
    //密码加密盐
    @Column(name="password_salt",nullable = false)
    private String passwordSalt;
}