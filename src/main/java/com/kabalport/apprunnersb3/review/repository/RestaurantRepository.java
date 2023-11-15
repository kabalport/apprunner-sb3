package com.kabalport.apprunnersb3.review.repository;

import com.kabalport.apprunnersb3.review.model.RestaurantEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<RestaurantEntity, Long> {
}
