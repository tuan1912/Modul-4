package cg.service;

import cg.model.Branch;

import java.util.List;

public interface IBranchService {
    public List<Branch> findAll();

    public Branch findById(long id);
}
