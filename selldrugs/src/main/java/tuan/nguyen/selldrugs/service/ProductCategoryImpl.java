package tuan.nguyen.selldrugs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tuan.nguyen.selldrugs.model.ProductCategory;
import tuan.nguyen.selldrugs.repository.ProductCategoryRepository;

import java.util.List;

@Service
public class ProductCategoryImpl implements IProductCategoryService{
    @Autowired
    ProductCategoryRepository productCategoryRepository;
    @Override
    public List<ProductCategory> findAll() {
        return (List<ProductCategory>) productCategoryRepository.findAll();
    }
}
