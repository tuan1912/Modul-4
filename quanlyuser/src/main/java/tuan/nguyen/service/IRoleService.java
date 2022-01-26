package tuan.nguyen.service;

import org.springframework.stereotype.Service;
import tuan.nguyen.model.Role;

import java.util.List;
import java.util.Optional;


public interface IRoleService {
    List<Role> findAll();
    Role findById(long id);
}
