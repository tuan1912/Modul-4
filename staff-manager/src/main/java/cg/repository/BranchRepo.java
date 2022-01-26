package cg.repository;

import cg.model.Branch;
import org.springframework.data.repository.CrudRepository;

public interface BranchRepo extends CrudRepository<Branch, Long> {
}
