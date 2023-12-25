package controller;

import domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.ProductServiceImpl;

@CrossOrigin('*')
@RestController
@RequestMapping("/api")
public class ProdctController {
    @Autowired
    ProductServiceImpl productService;

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
