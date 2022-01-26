package cg.service;

import cg.model.Staff;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;

public interface IStaffService {
    public List<Staff> findAll();

    public Page<Staff> findAll(Pageable pageable);

    public void save(Staff staff);

    public void delete(long id);

    public Staff findById(long id);

    public ArrayList<Staff> findByName(String name);

    public List<Staff> sortSalary();

    public List<Staff> sortAge();
}
