package uk.ac.westminster.products_api;

public class Customer {

    private static int customerCount = 0;

    private Long id;
    private String name;
    private String email;
    private Address address;
    private String[] tags;

    public Customer() {
        customerCount++;
    }

    public Customer(Long id, String name, String email, Address address, String[] tags) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
        this.tags = tags;
        customerCount++;
    }

    public Long getId() { return id; }

    public String getName() { return name; }

    public String getEmail() { return email; }

    public Address getAddress() { return address; }

    public String [] getTags() { return tags; }

    public static int getCustomerCount() { return customerCount; }

}
