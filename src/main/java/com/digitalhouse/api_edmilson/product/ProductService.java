package com.digitalhouse.api_edmilson.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public List<Product> getProducts(){
        return productRepository.findAll();
    }

    public Optional<Product> getProductById(Integer productId){
        return productRepository.findById(productId);
    }

    public void addNewProduct(Product product){
        Optional<Product> productOptional = productRepository.findProductById(product.getID());
        if(productOptional.isPresent()){
            throw new IllegalStateException("este ID já está sendo usado!");
        }
        productRepository.save(product);
    }

    public void deleteProduct(Integer productId){
        boolean exists = productRepository.existsById(productId);
        if(!exists){
            throw new IllegalStateException("produto com id " + productId + " não existe");
        }
        productRepository.deleteById(productId);
    }

    @Transactional
    public void updateProduct(Integer productId, String description, String providerDescription, double price){
        Product product = productRepository.findById(productId).orElseThrow(() -> new IllegalStateException(" produto com id " + productId + " não existe "));

        if (description != null && description.length() > 0 && !Objects.equals(product.getDescription(), description)){
            product.setDescription(description);
        }

        if(providerDescription != null && providerDescription.length() > 0 && !Objects.equals(product.getProviderDescription(), providerDescription)){
            product.setProviderDescription(providerDescription);
        }
        product.setPrice(price);
    }
}
