package com.wq.springboot.dao;

import com.wq.springboot.entity.AccUser;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccUserJpaDao extends JpaRepository<AccUser, Long> {
}