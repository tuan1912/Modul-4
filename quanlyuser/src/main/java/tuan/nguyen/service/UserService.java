package tuan.nguyen.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tuan.nguyen.model.User;
import tuan.nguyen.repository.UserRepository;

import java.util.List;

@Service
public class UserService implements IUserService{
    @Autowired
    UserRepository userRepository;
    @Override
    public List<User> findAll() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public User findById(long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public void delete(long id) {
        userRepository.deleteById(id);
    }
}
