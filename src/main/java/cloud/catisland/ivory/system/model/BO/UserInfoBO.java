package cloud.catisland.ivory.system.model.BO;

import lombok.Data;

@Data
public class UserInfoBO {
    //用户ID
    private long uid;
    //用户名
    private String user_name;
    //用户游戏账号
    private String user_game_id;
}