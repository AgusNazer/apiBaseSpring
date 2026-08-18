package com.apiBase.demo.controller;

import com.apiBase.demo.model.Product;
import com.apiBase.demo.repository.IProductRepository;
import com.apiBase.demo.service.IProductService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final IProductService productService;

    public ProductController(IProductService productService){
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getProducts(){
        return productService.getProduct();
    }

    @GetMapping("/{codProduct}")
    public ResponseEntity<?> getProductById(@PathVariable Long codProduct){
        Product product = productService.findProductById(codProduct);
        if(product == null){
            return (ResponseEntity<?>) ResponseEntity.status(HttpStatus.NOT_FOUND)
            .body("No se encuentra un producto con ese codigo");
        }
        return ResponseEntity.ok(product);
    }
}
