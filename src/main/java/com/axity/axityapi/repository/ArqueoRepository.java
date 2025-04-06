package com.axity.axityapi.repository;

import com.axity.axityapi.model.entity.Arqueo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ArqueoRepository extends JpaRepository<Arqueo, Long> {
    List<Arqueo> findByFechaBetween(LocalDate inicio, LocalDate fin);
}
