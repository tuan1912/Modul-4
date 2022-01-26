package tuan.nguyen.selldrugs.service;

import tuan.nguyen.selldrugs.model.ProductCategory;

import java.util.List;

public interface IProductCategoryService {
    List<ProductCategory> findAll();
}
