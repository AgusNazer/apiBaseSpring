package com.apiBase.demo.service;

import com.apiBase.demo.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {
    @Override
    public List<Product> getProduct() {
        return List.of();
    }

    @Override
    public Product findProductById(Long id) {
        return null;
    }

    @Override
    public Product createProduct(Product product) {
        return null;
    }

    @Override
    public Product updateProduct(Long codProduct, Product product) {
        return null;
    }

    @Override
    public boolean deleteProduct(Long codProduct) {
        return false;
    }
}
