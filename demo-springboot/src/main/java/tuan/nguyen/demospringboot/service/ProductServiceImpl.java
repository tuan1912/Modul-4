package tuan.nguyen.demospringboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tuan.nguyen.demospringboot.model.Product;
import tuan.nguyen.demospringboot.repository.IProductRepository;

import java.util.List;
@Service
public class ProductServiceImpl implements IProductService{
    @Autowired
    IProductRepository productRepository;
    @Override
    public List<Product> findAll() {
        return (List<Product>) productRepository.findAll();
    }

    @Override
    public Product findById(long id) {
        return productRepository.findById(id).get();
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void delete(long id) {
        productRepository.deleteById(id);
    }
}
