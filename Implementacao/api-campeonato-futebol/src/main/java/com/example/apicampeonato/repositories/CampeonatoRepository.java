package com.example.apicampeonato.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.apicampeonato.models.Campeonato;

@Repository
public interface CampeonatoRepository extends JpaRepository<Campeonato, Long>{

}
