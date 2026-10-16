package uk.ac.westminster.products_api;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ProductService {

    private Map<Long, Product> products = new HashMap<>();
    private Long nextId = 1L;


    public List<Product> getAllProducts() {

        return new ArrayList<>(products.values());
    }

    public Product addProduct(Product product) {
        product.setId(nextId++);
        products.put(product.getId(), product);
        return product;
    }

    public Optional<Product> getProductById(Long id) {
        return Optional.ofNullable(products.get(id));
    }

    public void deleteProduct(Long id) {
        products.remove(id);
    }

    public List<Product> findByName(String name) {
        return products.values().stream().filter(p -> p.getName().contains(name)).toList();
    }

    public List<Product> findCheaperThan(double price) {
        return products.values().stream().filter(p -> p.getPrice() < price).toList();
    }

}
