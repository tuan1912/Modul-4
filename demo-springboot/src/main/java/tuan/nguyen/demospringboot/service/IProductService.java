package tuan.nguyen.demospringboot.service;

import tuan.nguyen.demospringboot.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();
    Product findById(long id);
    Product save(Product product);
    void delete(long id);
}
