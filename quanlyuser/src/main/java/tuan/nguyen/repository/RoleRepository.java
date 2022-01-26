package tuan.nguyen.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tuan.nguyen.model.Role;


public interface RoleRepository extends CrudRepository <Role, Long>{
}
