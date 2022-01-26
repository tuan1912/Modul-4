package tuan.nguyen.selldrugs.service;

import tuan.nguyen.selldrugs.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();
    Product findById(long id);
    void save(Product product);
    void delete(long id);
}
