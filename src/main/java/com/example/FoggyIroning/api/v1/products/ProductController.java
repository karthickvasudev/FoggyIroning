package com.example.FoggyIroning.api.v1.products;

import com.example.FoggyIroning.api.v1.products.modals.ProductModal;
import com.example.FoggyIroning.securityConfiguration.googleauthenticator.TokenDetails;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(path = "api/v1/products")
public class ProductController {
    private final ProductService productService;
    private final TokenDetails tokenDetails;
    @PostMapping("create")
    public Product createProduct(@RequestBody ProductModal modal) {
        return productService.createProduct(modal);
    }

    @GetMapping(path = "getall")
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping(path = "{productId}")
    public Product getProduct(@PathVariable String productId){
        return productService.getProduct(productId);
    }

    @DeleteMapping(path = "{productId}")
    public void deleteProduct(@PathVariable String productId){
        productService.deleteProduct(productId);
    }
    @PutMapping(path = "{productId}")
  public Product updateProduct(@PathVariable String productId, @RequestBody ProductModal modal){
       return productService.updateProducts(productId,modal);
    }

}
