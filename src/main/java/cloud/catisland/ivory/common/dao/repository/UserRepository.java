package cloud.catisland.ivory.common.dao.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import cloud.catisland.ivory.common.dao.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findById(long id);
    Optional<User> findByUserName(String username);
    void deleteById(Long id);
	Optional<User> findByNickName(String nickname);
}