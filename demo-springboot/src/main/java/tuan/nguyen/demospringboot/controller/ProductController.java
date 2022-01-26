package tuan.nguyen.demospringboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tuan.nguyen.demospringboot.model.Product;
import tuan.nguyen.demospringboot.service.IProductService;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/products")
public class ProductController {
    @Autowired
    IProductService productService;
    @GetMapping
    public ResponseEntity<List<Product>> products(){
        return new ResponseEntity<>(productService.findAll(), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Product> create(Product product){
        productService.save(product);
        return new ResponseEntity<>(product,HttpStatus.OK) ;//ResponseEntity mang theo duoc trang thai thay vi chi list
    }
    @PutMapping("/{id}")
    public ResponseEntity<Product> update(@PathVariable long id,@RequestBody Product product){
        product.setId(id);
        productService.save(product);
        return new ResponseEntity<>(product,HttpStatus.OK);
    }
    @GetMapping ("/{id}")
    public ResponseEntity<Product> findById(@PathVariable long id){
        return new ResponseEntity<>(productService.findById(id),HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable long id){
        productService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }


}
