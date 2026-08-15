package com.apiBase.demo.service;

import com.apiBase.demo.model.Product;
import com.apiBase.demo.repository.IProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {

    public ProductService(IProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    private final IProductRepository productRepository;



    @Override
    public List<Product> getProduct() {
        return productRepository.findAll();
    }

    @Override
    public Product findProductById(Long codProd) {
        return productRepository.findById(codProd).orElse(null);
    }

    @Override
    public Product createProduct(Product product) {
        if(product == null){
            return null;
        }
        //la id se genera automaticamente en la db y con esto la devolvemos junto con el produto
        return productRepository.save(product);

    }

    @Override
    public Product updateProduct(Long codProduct, Product product) {
        Product productExists = findProductById(codProduct);
        if(productExists==null){
            return null;
        }
        //actualizar los datos con el producto
        productExists.setCategory(product.getCategory());
        productExists.setDescription(product.getDescription());
        productExists.setName(product.getName());
        productExists.setPrice(product.getPrice());
        productExists.setMark(product.getMark());
        productExists.setStock(product.getStock());

        return productRepository.save(productExists);
    }

    @Override
    public boolean deleteProduct(Long codProduct) {
        Product prodExists = findProductById(codProduct);
        if(prodExists == null){
            return false;
        }
        productRepository.delete(prodExists);
        return true;
    }
}
