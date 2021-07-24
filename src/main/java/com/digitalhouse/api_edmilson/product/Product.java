package com.digitalhouse.api_edmilson.product;


import javax.persistence.*;

@Entity
@Table
public class Product {

    @Id
    @SequenceGenerator(name = "student_sequence", sequenceName = "student_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_sequence")
    private Integer ID;

    @Column(nullable = false, length = 255)
    private String description;

    @Column(nullable = false, length = 255)
    private String providerDescription;

    @Column(nullable = false)
    private double price;

    public Product(){}

    public Product(Integer ID, String description, String providerDescription, double price) {
        this.ID = ID;
        this.description = description;
        this.providerDescription = providerDescription;
        this.price = price;
    }

    public Product(String description, String providerDescription, double price) {
        this.description = description;
        this.providerDescription = providerDescription;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "ID=" + ID +
                ", description='" + description + '\'' +
                ", providerDescription='" + providerDescription + '\'' +
                ", price='" + price + '\'' +
                '}';
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProviderDescription() {
        return providerDescription;
    }

    public void setProviderDescription(String providerDescription) {
        this.providerDescription = providerDescription;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
