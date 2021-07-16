package com.sb.gestoradb;

import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sb.gestoradb.domain.Player;
import com.sb.gestoradb.domain.Unity;
import com.sb.gestoradb.repositories.PlayerRepository;
import com.sb.gestoradb.repositories.UnityRepository;

@SpringBootApplication
public class GestoradbApplication implements CommandLineRunner {

	@Autowired
	private UnityRepository unityRepository;	
	@Autowired
	private PlayerRepository playerRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(GestoradbApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Unity unity1 = new Unity(null, "FutBeach", "Goiânia (Futebol Society, Futebol de Areia)");
		
		Player player1 = new Player(null, "VR7", new Date(), unity1);
		
		unity1.getPlayers().addAll(Arrays.asList(player1));

		this.unityRepository.saveAll(Arrays.asList(unity1));
		this.playerRepository.saveAll(Arrays.asList(player1));
		
	}

}
