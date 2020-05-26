package cloud.catisland.ivory.common.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cloud.catisland.ivory.common.dao.model.Topic;
import cloud.catisland.ivory.common.dao.repository.TopicRepository;

 @Service
public class TopicService {

    @Autowired
    TopicRepository topicRepository;

    public List<Topic> getAlltpcs(){
        return topicRepository.findAll();
    }
}