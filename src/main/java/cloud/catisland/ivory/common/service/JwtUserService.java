package cloud.catisland.ivory.common.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class JwtUserService implements UserDetailsService {

    @Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        PasswordEncoder passwordEncoder=new BCryptPasswordEncoder();
        //TODO 真实系统需要从数据库或缓存中获取，这里对密码做了加密
        return User.builder().username("Jack").password(passwordEncoder.encode("jack-password")).roles("USER").build();
	}

	public String saveUserLoginInfo(UserDetails principal) {
		return null;
	}
}