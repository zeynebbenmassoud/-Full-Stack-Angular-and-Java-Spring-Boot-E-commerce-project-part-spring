package com.zeyneb.eommerce.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.zeyneb.eommerce.entity.ProductCategory;

@RepositoryRestResource(collectionResourceRel = "productCategory", path = "product_category") // name of JSON entry - /product-category 
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long>{

}
