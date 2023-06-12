package com.robo.ancora.guilherme.repositories;

import java.time.LocalDateTime;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.robo.ancora.guilherme.entities.PostBling;

public interface PostBlingRepository extends JpaRepository<PostBling, Long>{

	Page<PostBling> findAllByDatRequestBetween(LocalDateTime dataInicio, LocalDateTime dataFim, Pageable pageable);
}
