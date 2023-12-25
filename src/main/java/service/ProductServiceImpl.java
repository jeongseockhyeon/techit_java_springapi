package service;

import domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.ProductRepository;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired//외부 클래스 불러오면서 생성
    private ProductRepository productRepository;

    @Override
    public Product save(Product product){
        try{
            return productRepository.save(
                    new Product(
                            product.getProductName(),
                            product.getPrice()
                    )
            );
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Optional<Product> findById(Long id) {
       try {
           Optional<Product> productData = productRepository.findById(id);
           if (productData.isPresent()){
               return productData;
           }
       } catch (Exception e){
           e.printStackTrace();
       }
       return null;
    }

    @Override
    public Product update(Long id, Product product) {
        try {
            Optional<Product> productData = productRepository.findById(id);
            if(productData.isPresent()){
                Product _product = productData.get();
                _product.setProductName(product.getProductName());
                _product.setPrice(product.getPrice());
                productRepository.save(_product);
            } else {
                return null;
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        try{
            productRepository.deleteById(id);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
