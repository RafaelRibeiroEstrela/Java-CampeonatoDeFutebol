package com.example.apicampeonato.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.apicampeonato.models.Estadio;

@Repository
public interface EstadioRepository extends JpaRepository<Estadio, Long>{

}
