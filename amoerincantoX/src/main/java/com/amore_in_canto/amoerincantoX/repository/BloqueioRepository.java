package com.amore_in_canto.amoerincantoX.repository;

import com.amore_in_canto.amoerincantoX.domain.Bloqueio;
import com.amore_in_canto.amoerincantoX.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface BloqueioRepository extends JpaRepository<Bloqueio,Long>, JpaSpecificationExecutor<Bloqueio>{
    Optional<Bloqueio> findById(Long id);

    @Query("SELECT COUNT(b) > 0 FROM Bloqueio b WHERE (:startDate <= b.endDate AND :endDate >= b.startDate)")

    boolean existsByPeriodo(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);
}

