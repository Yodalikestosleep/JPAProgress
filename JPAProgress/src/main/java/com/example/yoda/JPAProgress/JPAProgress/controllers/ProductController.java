package com.example.yoda.JPAProgress.JPAProgress.controllers;

import com.example.yoda.JPAProgress.JPAProgress.entities.ProductEntity;
import com.example.yoda.JPAProgress.JPAProgress.repository.ProductRespository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductRespository productRespository;
    private final Integer Page_Size = 5;

    public ProductController(ProductRespository productRespository){
        this.productRespository = productRespository;
    }

   @GetMapping("/getrtx")
   public List<ProductEntity> getAllRTXProducts(){
       return productRespository.findByTitleLikeOrderByPrice("%RTX%");


   }
   @GetMapping("/getall")
   public List<ProductEntity> getAllProducts(){
        return productRespository.findByOrderByPrice();
   }

   @GetMapping("/sort")
   public Page<ProductEntity> sortBy(@RequestParam(defaultValue = "id") String sortby,
                                     @RequestParam(defaultValue = "1") Integer pageNumber){
//        return productRespository.findBy(Sort.by(
//                Sort.Order.desc(sortby),
//                Sort.Order.asc(("Price")) //if any field have save "sortby" field it will sort them on basis of their price
//
//        ));
        //can also do (Sort.by(Sort.Order.desc(sortby)) -> will sort in non-ascending order
       Pageable pageable = PageRequest.of(pageNumber,
               Page_Size,
               Sort.by(sortby));
       return productRespository.findAll(pageable);





   }


}
