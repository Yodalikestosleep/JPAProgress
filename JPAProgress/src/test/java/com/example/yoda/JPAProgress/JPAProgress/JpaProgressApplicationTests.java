package com.example.yoda.JPAProgress.JPAProgress;

import com.example.yoda.JPAProgress.JPAProgress.entities.ProductEntity;
import com.example.yoda.JPAProgress.JPAProgress.repository.ProductRespository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class JpaProgressApplicationTests {
    @Autowired
    ProductRespository productRespository;

	@Test
	void contextLoads() {
	}
    @Test
    void testRepository(){ //created a test for insertion of data to database
        ProductEntity productEntity =  ProductEntity
                .builder()
                .sku("RTX50600")
                .title("NVIDIA GeForce RTX 5060")
                .price(BigDecimal.valueOf(699.99))
                .quantity(41)
                .build();
        ProductEntity savedProductEntity = productRespository.save(productEntity);
        System.out.println(savedProductEntity);
    }

    @Test
    void testFetchRepository(){
        List<ProductEntity> listOfAllProduct = productRespository.findAll();
        System.out.println(listOfAllProduct);
    }
    @Test
    void testCustomGet(){
        //created a custom query when used a function with specific format
        ProductEntity productEntity = productRespository.findByTitle("Intel Arc A770");
        System.out.println(productEntity);
    }

    @Test
    void testFindByCreatedAtAfter(){
        List<ProductEntity> productEntityList = productRespository.findByCreatedAtAfter(LocalDateTime.of(2024,1,1,0,0,0));
        System.out.println(productEntityList);
    }

    @Test
    void testFindByPriceANDQuantity(){
        List<ProductEntity> productEntityList = productRespository.findByPriceAndQuantity(BigDecimal.valueOf(899.99),4);
        System.out.println(productEntityList);

    }

    @Test
    void testfindByTitleAndPrice(){
        Optional<ProductEntity> productEntity = productRespository.findByTitleAndPrice("NVIDIA GeForce RTX 5080",BigDecimal.valueOf(1299.99));
        if(productEntity.isPresent())System.out.println(productEntity);
    }





}
