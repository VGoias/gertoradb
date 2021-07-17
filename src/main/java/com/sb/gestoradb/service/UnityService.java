package com.sb.gestoradb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sb.gestoradb.domain.Unity;
import com.sb.gestoradb.dtos.UnityDTO;
import com.sb.gestoradb.repositories.UnityRepository;
import com.sb.gestoradb.service.exceptions.ObjectNotFoundException;

@Service
public class UnityService {

	@Autowired
	private UnityRepository repository;

	public Unity findById(Integer id) {
		Optional<Unity> obj = repository.findById(id);
		return obj.orElseThrow(
				() -> new ObjectNotFoundException("Procurei em tudo e não encontrei registros para o filtro " + id
						+ ". [INFOTEC: Tipo " + Unity.class.getName() + "]"));
	}

	public List<Unity> findAll() {
		return repository.findAll();
	}
	
	public Unity create(Unity obj) {
		obj.setId(null);
		return repository.save(obj);
	}
	
	public Unity update(Integer id, UnityDTO objDTO) {
		Unity obj = findById(id);
		obj.setName(objDTO.getName());
		obj.setDescription(objDTO.getDescription());

		return repository.save(obj);
	}
}
