package com.stms.service;

import com.stms.bean.Product;
import com.stms.repo.ProductRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepo productDao;

    public boolean saveOrUpdateProduct(Product product) {
        productDao.save(product);
        return true;
    }

    public boolean deleteProductById(Long productId) {
        productDao.deleteById(productId);
        return true;
    }
    
    public Product getProductById(Long productId) {
        return productDao.findById(productId).orElse(null);
    }

    public List<Product> getAllProducts() {
        Iterator<Product> iterator = productDao.findAll().iterator();
        List<Product> productList = new ArrayList<>();
        while (iterator.hasNext()) {
            productList.add(iterator.next());
        }
        return productList;
    }
}

