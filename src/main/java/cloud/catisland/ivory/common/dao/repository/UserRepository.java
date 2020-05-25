package cloud.catisland.ivory.common.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cloud.catisland.ivory.common.dao.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findById(long id);
    void deleteById(Long id);
}