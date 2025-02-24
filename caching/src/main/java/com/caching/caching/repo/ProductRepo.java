package com.caching.caching.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.caching.caching.entity.Product;

public interface ProductRepo  extends JpaRepository<Product, Long>{

}
