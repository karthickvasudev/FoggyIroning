package com.example.FoggyIroning.api.v1.products;

import com.example.FoggyIroning.api.v1.products.modals.ProductModal;
import com.example.FoggyIroning.securityConfiguration.googleauthenticator.TokenDetails;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {
    private final TokenDetails tokenDetails;
    private final ProductRepository productRepository;
    public Product createProduct(ProductModal modal) {
        Product product = Product.builder()
                .productName(modal.getProductName())
                .quantity(modal.getQuantity())
                .price(modal.getPrice())
                .active(modal.getActive())
                .createdUserEmail(tokenDetails.getEmail())
                .createdUserName(tokenDetails.getName())
                .createdOn(LocalDateTime.now())
                .build();
        return productRepository.save(product);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProduct(String productId) {
        return productRepository.findById(productId).get();
    }

    public void deleteProduct(String productId) {
        productRepository.deleteById(productId);
    }

    public Product updateProducts(String productId, ProductModal modal){
        Product product = productRepository.findById(productId).get();
        product.setProductName(modal.getProductName());
        product.setQuantity(modal.getQuantity());
        product.setPrice(modal.getPrice());
        product.setActive(modal.getActive());
        product.setLastUpdatedOn(LocalDateTime.now());
        product.setLastUpdatedUserName(tokenDetails.getName());
        product.setLastUpdatedUserEmail(tokenDetails.getEmail());
        return productRepository.save(product);
    }
}
