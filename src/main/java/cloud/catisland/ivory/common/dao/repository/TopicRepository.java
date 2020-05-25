package cloud.catisland.ivory.common.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cloud.catisland.ivory.common.dao.model.Topic;

public interface TopicRepository extends JpaRepository<Topic,Long>{
    
}