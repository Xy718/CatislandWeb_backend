package cloud.catisland.ivory.common.dao.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Data;

/**
/* 展示贴orm对象
 * @Author: Xy718
 * @Date: 2020-05-25 21:13:21
 * @LastEditors: Xy718
 * @LastEditTime: 2020-05-29 16:15:58
 */
@Data
@Entity
@Table(name = "topic")
@EntityListeners(AuditingEntityListener.class)
public class Topic {

    // TopicID
    @Id
    @GeneratedValue
    private long tid;

    // 发布用户ID
    @Column(nullable = false)
    private long uid;

    // 发布用户名
    @Column(nullable = false, unique = true)
    private String user_name;

    // 标题
    @Column
    private String title;

    // 内容
    @Column
    private String content;

    // 图片集合
    @Column
    private List<String> imgs;

    // 发布时间
    @CreatedDate
    @Column(nullable = false)
    private Date create_time;

    @LastModifiedDate
    @Column(nullable = false)
    private Date update_time;

    //帖子状态 -1/0  删除/正常
    @Column(nullable = false)
    private String status_flag="0";
}
