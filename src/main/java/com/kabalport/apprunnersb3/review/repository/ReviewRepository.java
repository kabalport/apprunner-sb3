package com.kabalport.apprunnersb3.review.repository;

import com.kabalport.apprunnersb3.review.model.ReviewEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<ReviewEntity, Long>, ReviewRepositoryCustom {
}
