package cloud.catisland.ivory.common.dao.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="topic")
public class Topic {
    
    //TopicID
    @Id
    @GeneratedValue
    private long tid;
    
    //用户ID
    @Column(nullable = false)
    private long uid;

    //用户名
    @Column(nullable = false, unique = true)
    private String user_name;

}
