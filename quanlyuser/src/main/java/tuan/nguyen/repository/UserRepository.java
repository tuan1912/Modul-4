package tuan.nguyen.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import tuan.nguyen.model.User;


public interface UserRepository extends PagingAndSortingRepository<User,Long> {

}
