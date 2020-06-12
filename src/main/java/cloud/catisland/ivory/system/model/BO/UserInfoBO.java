package cloud.catisland.ivory.system.model.BO;

import cloud.catisland.ivory.common.dao.model.User;
import lombok.Data;

@Data
public class UserInfoBO {
	//用户ID
    private long uid;
    //用户名
    private String user_name;
    //用户游戏账号
    private String user_game_id;
    
    /**
     * 从DO中创建BO角色
     * @param userDO
     */
    public UserInfoBO(User userDO) {
        this.uid=userDO.getUid();
        this.user_name=userDO.getUserName();
        this.user_game_id=userDO.getUserGameID();
	}
}