package com.sb.gestoradb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sb.gestoradb.domain.Player;
import com.sb.gestoradb.domain.Unity;
import com.sb.gestoradb.dtos.PlayerDTO;
import com.sb.gestoradb.repositories.PlayerRepository;
import com.sb.gestoradb.service.exceptions.ObjectNotFoundException;

@Service
public class PlayerService {

	@Autowired
	private PlayerRepository repository;
	
	@Autowired
	private UnityService unityService;

	public Player findById(Integer id) {
		Optional<Player> obj = repository.findById(id);
		return obj.orElseThrow(
				() -> new ObjectNotFoundException("Procurei em tudo e não encontrei registros para o filtro " + id
						+ ". [INFOTEC: Tipo " + Player.class.getName() + "]"));
	}

	public List<Player> findAll(Integer id_unity) {
		unityService.findById(id_unity);
		return repository.findAllByUnity(id_unity);
	}
	
	public Player update(Integer id, PlayerDTO objDto) {
		Player obj = findById(id);
		updateData(obj, objDto);

		return repository.save(obj);
	}
	
	private void updateData(Player obj, PlayerDTO objDto) {
		obj.setNick(objDto.getNick());
		obj.setBirth(objDto.getBirth());		
	}

	public Player create(Integer id_unity, Player obj) {
		Unity unity = unityService.findById(id_unity);
		obj.setUnity(unity);
		return repository.save(obj);
	}

	public void delete(Integer id) {
		findById(id);
		repository.deleteById(id);
	}
}
