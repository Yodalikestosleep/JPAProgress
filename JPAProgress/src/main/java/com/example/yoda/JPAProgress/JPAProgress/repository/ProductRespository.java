package com.example.yoda.JPAProgress.JPAProgress.repository;

import com.example.yoda.JPAProgress.JPAProgress.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRespository extends JpaRepository<ProductEntity,Long> {
    ProductEntity findByTitle(String s);
    List<ProductEntity> findByCreatedAtAfter(LocalDateTime after);

    List<ProductEntity> findByPriceAndQuantity(BigDecimal price, int quantity);

    @Query("select e from ProductEntity e where e.title=?1 and e.price=?2")
    Optional<ProductEntity> findByTitleAndPrice(String title, BigDecimal price);

    List<ProductEntity> findByTitleLikeOrderByPrice(String title);


}
