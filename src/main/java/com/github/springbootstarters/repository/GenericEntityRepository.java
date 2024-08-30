package com.github.springbootstarters.repository;

import com.github.springbootstarters.model.GenericEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenericEntityRepository extends JpaRepository<GenericEntity, Long> {

}