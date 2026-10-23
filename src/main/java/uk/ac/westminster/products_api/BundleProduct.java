// It is IS-A, with a HAS-A inside it. A BundleProduct IS-A Product, it has an id, name and price and can be listed, searched and sold like any other item. The list of items it contains is a HAS-A, which is why it is a field.
package uk.ac.westminster.products_api;

import java.util.ArrayList;
import java.util.List;

public class BundleProduct extends Product {

    private List<Product> items = new ArrayList<>();

    public BundleProduct() {}

    public BundleProduct(Long id, String name, double price, List<Product> items) {
        super(id, name, price);
        this.items = items;
    }

    public List<Product> getItems() {
        return items;
    }

}
