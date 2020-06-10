package cloud.catisland.ivory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import cloud.catisland.ivory.common.service.UserService;

@SpringBootApplication
public class IvoryTowerApplication {
    
    IvoryTowerApplication(UserService userService){
        userService.toString();
    }

    public static void main(String[] args) {
        SpringApplication.run(IvoryTowerApplication.class, args);
    }

}
