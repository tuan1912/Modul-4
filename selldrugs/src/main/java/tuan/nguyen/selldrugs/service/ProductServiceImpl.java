package tuan.nguyen.selldrugs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tuan.nguyen.selldrugs.model.Product;
import tuan.nguyen.selldrugs.repository.ProductRepository;

import java.util.List;
@Service
public class ProductServiceImpl implements IProductService {
    @Autowired
    ProductRepository productRepository;
    @Override
    public List<Product> findAll() {
        return (List<Product>) productRepository.findAll();
    }

    @Override
    public Product findById(long id) {
        return  productRepository.findById(id).get();
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public void delete(long id) {
        productRepository.deleteById(id);
    }
}
