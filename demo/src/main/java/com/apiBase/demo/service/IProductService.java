package com.apiBase.demo.service;

import com.apiBase.demo.model.Product;

import java.util.List;

// solo van los metodos sin implementar. La logica va en ProducService
public interface IProductService {

    //crud
    //get
    List<Product> getProduct();
    Product findProductById(Long id);
    //create
    Product createProduct(Product product);
    //update
    Product updateProduct(Long codProduct, Product product);
    //delete
    boolean deleteProduct(Long codProduct);
}
