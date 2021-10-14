package com.example.apicampeonato;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.apicampeonato.services.DatabaseService;

@SpringBootApplication
public class ApiCampeonatoFutebolApplication implements CommandLineRunner{
	
	@Autowired
	private DatabaseService service;

	public static void main(String[] args) {
		SpringApplication.run(ApiCampeonatoFutebolApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		service.makeDatabase();
		
	}

}
