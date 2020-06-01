package cloud.catisland.ivory.system.model.BO;

import java.io.Serializable;

import lombok.Data;

@Data
public class RegBO implements Serializable{
    private static final long serialVersionUID = -8836644929813047906L;
    
    String username;

    String password;
}