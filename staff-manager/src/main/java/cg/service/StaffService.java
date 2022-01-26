package cg.service;

import cg.model.Staff;
import cg.repository.StaffRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class StaffService implements IStaffService {
    @Autowired
    StaffRepo staffRepo;

    // Trả về 1 list
    @Override
    public List<Staff> findAll() {
        return (List<Staff>) staffRepo.findAll();
    }

    // Trả về 1 list đã phân trang
    @Override
    public Page<Staff> findAll(Pageable pageable) {
        return staffRepo.findAll(pageable);
    }

    @Override
    public void save(Staff staff) {
        staffRepo.save(staff);
    }

    @Override
    public void delete(long id) {
        staffRepo.deleteById(id);
    }

    @Override
    public Staff findById(long id) {
        return staffRepo.findById(id).get();
    }

    @Override
    public ArrayList<Staff> findByName(String name) {
        return staffRepo.findAllByName(name);
    }

    @Override
    public List<Staff> sortSalary() {
        List<Staff> list = findAll();
        list.sort(Comparator.comparing(Staff::getSalary));
        return list;
    }

    @Override
    public List<Staff> sortAge() {
        List<Staff> list = findAll();
        list.sort(Comparator.comparing(Staff::getAge));
        return list;
    }
}
