package com.lbg.demo.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lbg.demo.domain.Cat;

public interface CatRepo extends JpaRepository<Cat, Integer> {

}
