package tuan.nguyen.demospringboot.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import tuan.nguyen.demospringboot.model.Demo;
import tuan.nguyen.demospringboot.model.Product;

import java.util.List;

@Repository
public interface IProductRepository extends PagingAndSortingRepository<Product, Long> {
    @Query(nativeQuery = true, value = "select count(id) from product")
    Long countProduct();

    // tên,ảnh,tên loại product
    @Query(nativeQuery = true, value = "select product.name as namep, img, category.name as namec from product join category on product.category_id = category.id")
    List<Demo> getDemo();
}
