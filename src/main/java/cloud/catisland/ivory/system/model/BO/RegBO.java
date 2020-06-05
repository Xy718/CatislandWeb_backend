package cloud.catisland.ivory.system.model.BO;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.validation.annotation.Validated;

import lombok.Data;


@Data
public class RegBO implements Serializable{
    private static final long serialVersionUID = -8836644929813047906L;
    
    @Size(min=5,max=32,message = "用户名长度在5-32个字符之间哦")
    private String username;

    @Pattern(regexp = "^[a-zA-Z0-9_]{6,32}$",message = "密码长度在6-32个字符之间哦，包含大小写字母数字和下划线")
    private String password;
    
}