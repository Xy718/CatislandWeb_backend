package cloud.catisland.ivory.common.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cloud.catisland.ivory.common.dao.repository.TopicRepository;

@Service
public class TopicService {
    @Autowired
    private TopicRepository topicR;
}