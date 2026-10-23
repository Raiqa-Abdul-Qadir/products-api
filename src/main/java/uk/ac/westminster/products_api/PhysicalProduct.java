// A PhysicalProduct IS-A Product because it has an id, name and price like every other item in the shop and can be used anywhere a Product is expected.
// A ShoppingCart would not pass this test because it HAS-A list of Products rather than being a product itself.
package uk.ac.westminster.products_api;

public class PhysicalProduct extends Product {

    private double weightKg;
    private String dimensions;

    public PhysicalProduct() {}

    public PhysicalProduct(Long id, String name, double price, double weightKg, String dimensions) {
        super(id, name, price);
        this.weightKg = weightKg;
        this.dimensions = dimensions;
    }

    public double getWeightKg() {
        return weightKg;
    }

    public String getDimensions() {
        return dimensions;
    }
}
