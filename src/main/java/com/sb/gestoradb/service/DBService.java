package com.sb.gestoradb.service;

import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.sb.gestoradb.domain.Player;
import com.sb.gestoradb.domain.Unity;
import com.sb.gestoradb.repositories.PlayerRepository;
import com.sb.gestoradb.repositories.UnityRepository;

@Service
public class DBService {

	@Autowired
	private UnityRepository unityRepository;
	@Autowired
	private PlayerRepository playerRepository;

	@Bean
	public void generateDataBase() {

		Unity unity1 = new Unity(null, "FutBeach", "Goiânia (Futebol Society, Futebol de Areia)");
		Unity unity2 = new Unity(null, "BolaNaRede", "Goiânia (Futebol Society, Futebol de Campo)");

		Player player1 = new Player(null, "VR7", new Date(), "avançado completo, artilheiro, liderança", unity1);
		Player player2 = new Player(null, "Claudio Modric", new Date(), "oportunista; tatico; marcador; jogador consistente;", unity1);
		Player player3 = new Player(null, "Mateus Dybala", new Date(), "motorzinho; remate de trivela; marcador; propício a lesões;", unity1);
		Player player4 = new Player(null, "VR7", new Date(), "amador; cruzador; remate de longe;", unity2);
		Player player5 = new Player(null, "Mateus Dybala", new Date(), "tatico; oportunista;", unity2);

		unity1.getPlayers().addAll(Arrays.asList(player1,player2,player3,player4,player5));

		this.unityRepository.saveAll(Arrays.asList(unity1,unity2));
		this.playerRepository.saveAll(Arrays.asList(player1,player2,player3,player4,player5));
	}
}
