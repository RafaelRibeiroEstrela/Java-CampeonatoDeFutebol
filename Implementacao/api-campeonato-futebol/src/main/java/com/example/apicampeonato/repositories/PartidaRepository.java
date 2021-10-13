package com.example.apicampeonato.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.apicampeonato.models.Partida;

@Repository
public interface PartidaRepository extends JpaRepository<Partida, Long>{

}
