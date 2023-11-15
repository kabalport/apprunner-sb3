package com.kabalport.apprunnersb3.review.repository;

import com.kabalport.apprunnersb3.review.model.TestEntity;

import java.util.List;

public interface TestRepositoryCustom {

    public List<TestEntity> findAllByNameByQuerydsl(String name);
}
