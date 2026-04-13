package com.amore_in_canto.amoerincantoX.repository;

import com.amore_in_canto.amoerincantoX.domain.Bloqueio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BloqueioRepository extends JpaRepository<Bloqueio,Long>, JpaSpecificationExecutor<Bloqueio>{
    Optional<Bloqueio> findById(Long id);
}

