package tuan.nguyen.selldrugs.repository;

import org.springframework.data.repository.CrudRepository;
import tuan.nguyen.selldrugs.model.ProductCategory;

public interface ProductCategoryRepository extends CrudRepository<ProductCategory, Long> {
}
