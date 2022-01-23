package tuan.nguyen.service;

import tuan.nguyen.model.User;

import java.util.List;

public interface IUserService {
    List<User> findAll();
    User findById(long id);
    void delete(long id);
    void save(User user);

}
