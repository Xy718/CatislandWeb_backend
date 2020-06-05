package cloud.catisland.ivory.common.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cloud.catisland.ivory.common.dao.model.enums.UserRegStatus;
import cloud.catisland.ivory.common.dao.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    UserRepository uRepo;

    public UserRegStatus checkUserRegedByUsername(String username){
        return uRepo.findByUserName(username) == null ? UserRegStatus.UnRegist : UserRegStatus.Registed;
    }
}