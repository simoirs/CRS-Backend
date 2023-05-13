package com.CRS.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.CRS.model.Candidato;
import com.CRS.repository.CandidatoRepository;
import com.CRS.util.CandidatoUpdater;

@RestController
@RequestMapping("candidati")
public class CandidatoController {

	@Autowired
	CandidatoRepository repository;
	
	
	@GetMapping
	public List<Candidato> getAllCandidati() {
		return repository.findAll();
	}
	
	@GetMapping("/{id}")
	public Candidato getCandidato(@PathVariable long id) {
		Candidato candidato = repository.findById(id).get();
		if (candidato != null) {
			return candidato;
		} else {
			return null;
		}
	}
	
	@PostMapping
	public ResponseEntity<Candidato> createCandidato(@RequestBody Candidato candidato) {
		try {
			Candidato createdCandidato = repository.save(candidato);
			return new ResponseEntity<>(createdCandidato, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Candidato> updateCandidato(@PathVariable("id") long id, @RequestBody Candidato candidato) {
		Optional<Candidato> CandidatoToUpdateOptional = repository.findById(id);
		if(CandidatoToUpdateOptional.isPresent()) {
			Candidato CandidatoToUpdate = CandidatoToUpdateOptional.get();
			return new ResponseEntity<>(
					CandidatoUpdater.transferFields(CandidatoToUpdate, candidato), 
					HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<HttpStatus> deleteCandidato(@PathVariable("id") long id) {
		try {
			repository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}








