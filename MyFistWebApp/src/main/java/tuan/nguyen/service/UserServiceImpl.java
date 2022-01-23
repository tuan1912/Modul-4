package tuan.nguyen.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tuan.nguyen.model.User;
import tuan.nguyen.repository.UserRepository;

import java.util.List;
@Service
public class UserServiceImpl implements IUserService{
    @Autowired
    UserRepository userRepository;
    @Override
    public List<User> findAll() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public User findById(long id) {
        return (User) userRepository.findById(id).get();
    }

    @Override
    public void delete(long id) {
        userRepository.delete(id);
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }
}
