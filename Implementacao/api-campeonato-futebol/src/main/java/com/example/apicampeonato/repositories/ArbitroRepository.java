package com.example.apicampeonato.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.apicampeonato.models.Arbitro;

@Repository
public interface ArbitroRepository extends JpaRepository<Arbitro, Long>{

}
