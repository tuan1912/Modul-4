package tuan.nguyen.selldrugs.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tuan.nguyen.selldrugs.model.Product;
import tuan.nguyen.selldrugs.service.IProductCategoryService;
import tuan.nguyen.selldrugs.service.IProductService;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/products")
public class ProductController {
     @Autowired
    IProductService productService;
     @Autowired
    IProductCategoryService productCategoryService;
    @GetMapping
    public ResponseEntity<List<Product>> findAll(){
        return new ResponseEntity<>(productService.findAll(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Product> findById(@PathVariable long id){
        return new ResponseEntity<>(productService.findById(id),HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Product> create(Product product){
        productService.save(product);
        return new ResponseEntity<>(product,HttpStatus.OK) ;
    }
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable long id){
        productService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Product> update(@PathVariable long id,@RequestBody Product product){
        product.setId(id);
        productService.save(product);
        return new ResponseEntity<>(product,HttpStatus.OK);
    }


}
