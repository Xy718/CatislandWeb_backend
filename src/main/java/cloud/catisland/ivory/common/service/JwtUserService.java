package cloud.catisland.ivory.common.service;

import java.util.Date;
import java.util.Optional;
import java.util.function.Supplier;

import javax.annotation.Resource;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import cn.hutool.extra.spring.SpringUtil;


public class JwtUserService implements UserDetailsService {

	UserService uService;

	public JwtUserService(UserService uService) {
		this.uService=uService;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		// UserService uService=SpringUtil.getBean(UserService.class);
		// TODO 真实系统需要从数据库或缓存中获取，这里对密码做了加密
		// TODO 先不加密，测试一下
		cloud.catisland.ivory.common.dao.model.User u = uService.findByUserName(username).get();
		return User.builder()
				.username(u.getUserName())
				.password("{noop}"+u.getPassword())
				.roles("USER")
				.build();
		// return User.builder()
		// 		.username(u.getUserName())
		// 		.password("{bcrypt}"+passwordEncoder.encode("jack-password"))
		// 		.roles("USER")
		// 		.build();
	}

	public String saveUserLoginInfo(UserDetails user) {
		String salt = "123456ef"; //BCrypt.gensalt();  正式开发时可以调用该方法实时生成加密的salt
		//TODO 将salt保存到数据库或者缓存中
    	//redisTemplate.opsForValue().set("token:"+username, salt, 3600, TimeUnit.SECONDS);	
		Algorithm algorithm = Algorithm.HMAC256(salt);
		Date date = new Date(System.currentTimeMillis()+3600*1000);  //设置1小时后过期
        return JWT.create()
        		.withSubject(user.getUsername())
                .withExpiresAt(date)
                .withIssuedAt(new Date())
                .sign(algorithm);
	}

	public UserDetails getUserLoginInfo(String username) {
		String salt = "123456ef";
    	
    	//TODO 从数据库或者缓存中取出jwt token生成时用的salt
    	// salt = redisTemplate.opsForValue().get("token:"+username); 	
    	UserDetails user = loadUserByUsername(username);
    	//将salt放到password字段返回
		return User.builder()
				.username(user.getUsername())
				.password(salt)
				.authorities(user.getAuthorities())
				.build();
	}

	public void deleteUserLoginInfo(String username) {
		//TODO 清除数据库或者缓存中登录salt
	}
}