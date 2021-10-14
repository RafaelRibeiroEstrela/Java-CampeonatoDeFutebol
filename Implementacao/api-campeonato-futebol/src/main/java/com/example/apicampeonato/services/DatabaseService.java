package com.example.apicampeonato.services;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.example.apicampeonato.models.Arbitro;
import com.example.apicampeonato.models.Campeonato;
import com.example.apicampeonato.models.Estadio;
import com.example.apicampeonato.models.Jogador;
import com.example.apicampeonato.models.Partida;
import com.example.apicampeonato.models.Time;
import com.example.apicampeonato.models.enums.TipoArbitroEnum;
import com.example.apicampeonato.models.enums.TipoPartidaEnum;
import com.example.apicampeonato.models.enums.TipoPernaEnum;
import com.example.apicampeonato.models.enums.TipoPosicaoEnum;
import com.example.apicampeonato.repositories.ArbitroRepository;
import com.example.apicampeonato.repositories.CampeonatoRepository;
import com.example.apicampeonato.repositories.EstadioRepository;
import com.example.apicampeonato.repositories.JogadorRepository;
import com.example.apicampeonato.repositories.PartidaRepository;
import com.example.apicampeonato.repositories.TimeRepository;

@Service
public class DatabaseService {

	@Value("${spring.profiles.active}")
	private String profile;
	
	@Autowired
	private CampeonatoRepository campeonatoRepository;
	
	@Autowired
	private PartidaRepository partidaRepository;
	
	@Autowired
	private EstadioRepository estadioRepository;
	
	@Autowired
	private TimeRepository timeRepository;
	
	@Autowired
	private JogadorRepository jogadorRepository;
	
	@Autowired
	private ArbitroRepository arbitroRepository;
	
	public void makeDatabase() {
		
		if (profile.equals("test")) {
			
			Campeonato campeonato = new Campeonato();
			campeonato.setId(null);
			campeonato.setNome("Recopa sul americana");
			campeonato.setAno(2021);
			campeonato.setDataInicio(LocalDate.parse("10/10/1990", DateTimeFormatter.ofPattern("dd/MM/yyyy")));
			campeonato.setDataFim(LocalDate.parse("10/10/1990", DateTimeFormatter.ofPattern("dd/MM/yyyy")));
			campeonato = campeonatoRepository.save(campeonato);
			
			
			Estadio estadio = new Estadio();
			estadio.setId(null);
			estadio.setNome("Palestra Italia");
			estadio = estadioRepository.save(estadio);
			
			Time timeA = new Time();
			timeA.setId(null);
			timeA.setNome("Palmeiras");
			timeA.setNumeroDeJogadores(1);
			timeA = timeRepository.save(timeA);
			
			Time timeB = new Time();
			timeB.setId(null);
			timeB.setNome("Flamengo");
			timeB.setNumeroDeJogadores(1);
			timeB = timeRepository.save(timeB);
			
			Jogador jogador1 = new Jogador();
			jogador1.setId(null);
			jogador1.setNome("Carlos");
			jogador1.setEmail("carlos@gmail.com");
			jogador1.setCpf("04656777895");
			jogador1.setIdade(19);
			jogador1.setTipoPerna(TipoPernaEnum.DIREITA);
			jogador1.setTipoPosicao(TipoPosicaoEnum.GOLEIRO);
			jogador1.setTime(timeA);
			jogador1 = jogadorRepository.save(jogador1);
			
			Jogador jogador2 = new Jogador();
			jogador2.setId(null);
			jogador2.setNome("Marcelo");
			jogador2.setEmail("marcelo@gmail.com");
			jogador2.setCpf("04656777815");
			jogador2.setIdade(25);
			jogador2.setTipoPerna(TipoPernaEnum.DIREITA);
			jogador2.setTipoPosicao(TipoPosicaoEnum.GOLEIRO);
			jogador2.setTime(timeB);
			jogador2 = jogadorRepository.save(jogador2);
			
			Arbitro arbitro = new Arbitro();
			arbitro.setId(null);
			arbitro.setNome("Jose");
			arbitro.setEmail("jose@gmail.com");
			arbitro.setCpf("04478965898");
			arbitro.setIdade(33);
			arbitro.setTipoArbitro(TipoArbitroEnum.CENTRAL);
			arbitro = arbitroRepository.save(arbitro);
			
			Partida partida = new Partida();
			partida.setId(null);
			partida.setData(LocalDate.parse("10/10/1990", DateTimeFormatter.ofPattern("dd/MM/yyyy")));
			partida.setHoraInicio(LocalDateTime.of(1990, 10, 10, 20, 0, 0));
			partida.setHoraFim(LocalDateTime.of(1990, 10, 10, 22, 0, 0));
			partida.setCampeonato(campeonato);
			partida.setEstadio(estadio);
			partida.setTipoPartida(TipoPartidaEnum.FINAL);
			partida.getTimes().addAll(Arrays.asList(timeA, timeB));
			partida.getArbitros().addAll(Arrays.asList(arbitro));
			partidaRepository.save(partida);
			
		}
		
		
	}
	
	
}
