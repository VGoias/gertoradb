package com.sb.gestoradb.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.sb.gestoradb.domain.Unity;
import com.sb.gestoradb.dtos.UnityDTO;
import com.sb.gestoradb.service.UnityService;

//TODO study @RestController
@CrossOrigin("*")
@RestController
@RequestMapping(value = "/unities")
public class UnityResources {
	
	@Autowired
	private UnityService service;
	
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Unity> findById(@PathVariable Integer id){
		
		Unity obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping
	public ResponseEntity<List<UnityDTO>> findAll(){
		List<Unity> list = service.findAll();
		List<UnityDTO> listDto = list.stream().map(obj -> new UnityDTO(obj)).collect(Collectors.toList());
		
		return ResponseEntity.ok().body(listDto);
	}
	
	@PostMapping
	public ResponseEntity<Unity> create(@Valid @RequestBody Unity obj){		
		obj = service.create(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		
		return ResponseEntity.created(uri).build(); 
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<UnityDTO> update(@PathVariable Integer id,@Valid @RequestBody UnityDTO objDto){
		Unity newObj = service.update(id, objDto);
		
		return ResponseEntity.ok().body(new UnityDTO(newObj));
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		service.delete(id);
		
		return ResponseEntity.noContent().build();
	}
}
