package controller;

import domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.ProductServiceImpl;

import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class ProductController {
    @Autowired
    ProductServiceImpl productService;

    @GetMapping("/produts/{id}")
    public ResponseEntity<Optional<Product>> getProductById(@PathVariable("id") long id){
        try{
            return ResponseEntity.ok(productService.findById(id));
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @PostMapping("/products")
    public ResponseEntity<Product> createProduct(Product product){
        try{
            ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(productService.save(product));
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }


}
