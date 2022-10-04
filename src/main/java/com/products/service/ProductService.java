package com.products.service;

import java.util.List;

import javax.transaction.Transactional;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.products.dao.ProductRepository;
import com.products.entity.ProductEntity;
 
@Service
@Transactional
public class ProductService {
 
    @Autowired
    private ProductRepository repo;
     
    public List<ProductEntity> listAll() {
        return repo.findAll();
    }
     
    public void save(ProductEntity product) {
        repo.save(product);
    }
     
    public ProductEntity get(Integer id) {
        return repo.findById(id).get();
    }
     
    public void delete(Integer id) {
        repo.deleteById(id);
    }
}
