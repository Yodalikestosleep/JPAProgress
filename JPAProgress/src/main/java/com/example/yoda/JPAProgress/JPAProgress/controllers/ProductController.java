package com.example.yoda.JPAProgress.JPAProgress.controllers;

import com.example.yoda.JPAProgress.JPAProgress.entities.ProductEntity;
import com.example.yoda.JPAProgress.JPAProgress.repository.ProductRespository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductRespository productRespository;

    public ProductController(ProductRespository productRespository){
        this.productRespository = productRespository;
    }

   @GetMapping("/getall")
   public List<ProductEntity> getAllProducts(){
        //List<ProductEntity> listproductentity =
       return productRespository.findByTitleLikeOrderByPrice("%RTX%");


   }

}
