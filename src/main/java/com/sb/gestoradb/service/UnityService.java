package com.sb.gestoradb.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sb.gestoradb.domain.Unity;
import com.sb.gestoradb.repositories.UnityRepository;

@Service
public class UnityService {

	@Autowired
	private UnityRepository repository;
	
	public Unity findById(Integer id) {
		Optional<Unity> obj = repository.findById(id);
		return obj.orElse(null);
	}
}
