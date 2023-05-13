package com.CRS.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.CRS.model.Candidato;

public interface CandidatoRepository extends JpaRepository<Candidato, Long> {

}
