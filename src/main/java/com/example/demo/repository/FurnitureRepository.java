package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Furniture;

public interface FurnitureRepository extends JpaRepository<Furniture, Long> {

}
