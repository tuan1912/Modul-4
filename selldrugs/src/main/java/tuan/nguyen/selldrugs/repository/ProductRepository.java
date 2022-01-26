package tuan.nguyen.selldrugs.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import tuan.nguyen.selldrugs.model.Product;

public interface ProductRepository extends PagingAndSortingRepository<Product, Long> {
}
