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

    public ProductService() {
        addProduct(new DigitalProduct(null, "Clean Code (E-book)", 29.99, "/downloads/clean-code.pdf", 4.2));
        addProduct(new PhysicalProduct(null, "27-inch Monitor", 249.99, 5.4, "61cm x 41cm x 18cm"));
        addProduct(new BundleProduct(null, "Developer Bundle", 259.99, List.of(new DigitalProduct(null, "Clean Code (E-book)", 29.99, "/downloads/clean-code.pdf", 4.2), new PhysicalProduct(null, "27-inch Monitor", 249.99, 5.4, "61cm x 41cm x 18cm"))));
    }

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

    public List<String> getAllSummaries() {

        List<String> summaries = new ArrayList<>();

        for (Product p : products.values()) {
            summaries.add(p.getSummary());
        }
        return summaries;
    }

}
