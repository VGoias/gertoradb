package com.sb.gestoradb.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.sb.gestoradb.domain.Player;
import com.sb.gestoradb.dtos.PlayerDTO;
import com.sb.gestoradb.service.PlayerService;

//TODO study @RestController
@RestController
@RequestMapping(value = "/players")
public class PlayerResources {
	
	@Autowired
	private PlayerService service;
	
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Player> findById(@PathVariable Integer id){
		
		Player obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping
	public ResponseEntity<List<PlayerDTO>> findAll(@RequestParam(value = "unity", defaultValue = "0") Integer id_unity){
		List<Player> list = service.findAll(id_unity);
		List<PlayerDTO> listDto = list.stream().map(obj -> new PlayerDTO(obj)).collect(Collectors.toList());
		
		return ResponseEntity.ok().body(listDto);
	}
	
	@PostMapping
	public ResponseEntity<Player> create(@RequestParam(value = "unity", defaultValue = "0") Integer id_unity, @RequestBody Player obj){		
		
		Player newObj = service.create(id_unity, obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/players/{id}").buildAndExpand(newObj.getId()).toUri();
		
		return ResponseEntity.created(uri).build(); 
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<PlayerDTO> update(@PathVariable Integer id, @RequestBody PlayerDTO objDto){
		Player newObj = service.update(id, objDto);
		
		return ResponseEntity.ok().body(new PlayerDTO(newObj));
	}
	
	@PatchMapping(value = "/{id}")
	public ResponseEntity<PlayerDTO> updatePatch(@PathVariable Integer id, @RequestBody PlayerDTO objDto){
		Player newObj = service.update(id, objDto);
		
		return ResponseEntity.ok().body(new PlayerDTO(newObj));
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		service.delete(id);
		
		return ResponseEntity.noContent().build();
	}
}
