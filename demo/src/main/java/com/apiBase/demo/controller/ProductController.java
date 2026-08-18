package com.apiBase.demo.controller;

import com.apiBase.demo.model.Product;
import com.apiBase.demo.repository.IProductRepository;
import com.apiBase.demo.service.IProductService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public ResponseEntity<?> createProduct(@RequestBody Product product){
        Product productCreated = productService.createProduct(product);

        if(productCreated == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No se pudo crear el producto");
//            return ResponseEntity.badRequest().body("No se pudo crear el producto");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body("Product created successfully");
    }

    @PutMapping("/{codProduct}")
    public ResponseEntity<?> updateProduct(@PathVariable Long codProduct,
                                               @RequestBody Product productToUpdate){
        Product productUpdated = productService.updateProduct(codProduct, productToUpdate);
        if(productUpdated == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No fue posible editar el producto");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body("Product updated successfully");
    }

    @DeleteMapping("/{codProduct}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long codProduct){

        boolean deleted = productService.deleteProduct(codProduct);
        if(deleted == false){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No fue posible editar el producto");
        }
        return ResponseEntity.ok("Product deleted successfully");

    }

}














