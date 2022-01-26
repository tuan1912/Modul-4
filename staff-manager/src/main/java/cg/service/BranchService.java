package cg.service;

import cg.model.Branch;
import cg.repository.BranchRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BranchService implements IBranchService {
    @Autowired
    BranchRepo branchRepo;

    @Override
    public List<Branch> findAll() {
        return (List<Branch>) branchRepo.findAll();
    }

    // Tìm theo ID và trả về 1 đối tượng
    @Override
    public Branch findById(long id) {
        return branchRepo.findById(id).get();
    }
}
