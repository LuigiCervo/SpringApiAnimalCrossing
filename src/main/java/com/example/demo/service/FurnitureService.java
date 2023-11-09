package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Furniture;
import com.example.demo.repository.FurnitureRepository;

@Service
public class FurnitureService {
	
	@Autowired
	protected FurnitureRepository repo;
	
	public Furniture create(Furniture furniture) {
		return repo.save(furniture);
	}
	
	public List<Furniture> getAll() {
		return repo.findAll();
	}
	
	public Optional<Furniture> getById(Long furnitureid) {
		return repo.findById(furnitureid);
	}
	
	public void update(Long id, Furniture oldfurni, Furniture newfurni) {
		oldfurni.setName(newfurni.getName());
		oldfurni.setImage(newfurni.getImage());
		oldfurni.setPrice(newfurni.getPrice());
		oldfurni.setFurnitureType(newfurni.getFurnitureType());
	    repo.save(oldfurni);
		
	}
	
	public void delete(Long furnitureid) {
		repo.deleteById(furnitureid);
	}
}
