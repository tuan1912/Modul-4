package cg.repository;

import cg.model.Staff;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;

public interface StaffRepo extends PagingAndSortingRepository<Staff, Long> {
    @Query(value = "select s from Staff s where s.name like concat('%' ,:name, '%')")
    ArrayList<Staff> findAllByName(@Param("name") String name);
}
