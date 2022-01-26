package tuan.nguyen.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tuan.nguyen.model.Role;
import tuan.nguyen.repository.RoleRepository;

import java.util.List;
import java.util.Optional;

@Service
public class RoleService implements IRoleService{
    @Autowired
    RoleRepository roleRepository;
    @Override
    public List<Role> findAll() {
        return (List<Role>) roleRepository.findAll();
    }

    @Override
    public Role findById(long id) {
        return roleRepository.findById(id).get();
    }
}
