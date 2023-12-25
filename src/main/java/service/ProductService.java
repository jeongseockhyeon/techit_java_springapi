package service;

import domain.Product;

import java.util.Optional;

public interface ProductService {
    public Product save(Product product);
    public Optional<Product> findById(Long id); //Optional: null값을 조회시 알맞은 형태로 처리
    public Product update(Long id, Product product);
    public  void delete(Long id);
}
