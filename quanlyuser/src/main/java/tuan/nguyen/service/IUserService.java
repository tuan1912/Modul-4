package tuan.nguyen.service;

import org.springframework.stereotype.Service;
import tuan.nguyen.model.User;

import java.util.List;


public interface IUserService {
    List<User> findAll();
    User findById(long id);
    void save(User user);
    void delete(long id);

}
