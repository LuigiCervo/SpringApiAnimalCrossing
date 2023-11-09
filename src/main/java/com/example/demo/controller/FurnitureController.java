package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Furniture;
import com.example.demo.service.FurnitureService;

@RestController
@RequestMapping("/api/furniture")
public class FurnitureController {

	@Autowired
	private FurnitureService service;
	
	//201 CREATED -> created forniture's body
	@CrossOrigin("*")
	@PostMapping("/")
	public ResponseEntity<?> createFurniture(@RequestBody Furniture furniture) {
		Furniture createdFurniture = service.create(furniture);
		return ResponseEntity.ok(createdFurniture);
	}
	
	//200 OK -> Specific forniture's body
	//404 NOT FOUND -> Forniture not present in the DB
	@CrossOrigin("*")
	@GetMapping("/{id}")
	public ResponseEntity<Furniture> getFurniture(@PathVariable Long id){
		Optional<Furniture> record = service.getById(id);
		if(record.isPresent()) {
			return ResponseEntity.ok(record.get());
		}
		return new ResponseEntity<Furniture>(HttpStatusCode.valueOf(404));
	}
	
	//List of all fornitures
	@CrossOrigin("*")
	@GetMapping("/list")
	public List<Furniture> getAllFurnitures(){
		return service.getAll();
	}
	
	//200 OK -> Updated Forniture's body
	//404 NOT FOUND -> Forniture not present in the DB
	@CrossOrigin("*")
	@PutMapping("/{id}")
	public ResponseEntity<Furniture> updateFurniture(@RequestBody Furniture updatedfurniture, @PathVariable Long id){
		Optional<Furniture> record = service.getById(id);
		if(record.isPresent()) {
			service.update(id, record.get(), updatedfurniture);
			return ResponseEntity.ok(updatedfurniture);
		}
		return new ResponseEntity<Furniture>(HttpStatusCode.valueOf(404));
	}
	
	//200 OK -> Forniture deleted Successfully
	//404 NOT FOUND -> Forniture not present in the DB
	@CrossOrigin("*")
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteFurniture(@PathVariable Long id){
		Optional<Furniture> record = service.getById(id);
		if(record.isPresent()) {
			service.delete(id);
			return new ResponseEntity<Furniture>(HttpStatusCode.valueOf(200));
		}
		return new ResponseEntity<Furniture>(HttpStatusCode.valueOf(404));
	}
}
