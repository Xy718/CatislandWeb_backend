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
    @Column(nullable = false, unique = true)
    private String user_name;
    //用户游戏账号
    @Column(nullable = false)
    private String user_game_id;
    //用户游戏UUID
    @Column(nullable = false)
    private String user_game_uuid;
    //手机号
    @Column(nullable = false, unique = true)
    private String phone;
    //邮箱
    @Column(nullable = false, unique = true)
    private String email;
    //密码(BCrypt加密)
    @Column(nullable = false)
    private String password;
    //密码加密盐
    @Column(nullable = false)
    private String password_salt;
}