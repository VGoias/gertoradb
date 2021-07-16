package com.sb.gestoradb.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sb.gestoradb.domain.Unity;
import com.sb.gestoradb.service.UnityService;

//TODO study @RestController
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
}
