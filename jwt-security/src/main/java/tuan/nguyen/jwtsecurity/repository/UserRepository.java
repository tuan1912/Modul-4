package tuan.nguyen.jwtsecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tuan.nguyen.jwtsecurity.entity.User;


public interface UserRepository extends JpaRepository<User,Integer> {
    User findByUserName(String username);
}
