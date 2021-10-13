package com.example.apicampeonato.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.apicampeonato.models.Jogador;

@Repository
public interface JogadorRepository extends JpaRepository<Jogador, Long>{

}
