package com.sb.gestoradb.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sb.gestoradb.domain.Unity;
import com.sb.gestoradb.repositories.UnityRepository;
import com.sb.gestoradb.service.exceptions.ObjectNotFoundException;

@Service
public class UnityService {

	@Autowired
	private UnityRepository repository;
	
	public Unity findById(Integer id) {
		Optional<Unity> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Procurei em tudo e não encontrei registros para o(s) filtro(s) "+id+". [INFOTEC: Tipo "+Unity.class.getName()+"]"));
	}
}
