package com.amore_in_canto.amoerincantoX.repository;

import com.amore_in_canto.amoerincantoX.domain.Reserva;
import com.amore_in_canto.amoerincantoX.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long>, JpaSpecificationExecutor<Reserva> {
    Optional<Reserva> findById(Long id);

    @Query("SELECT COUNT(r) > 0 FROM Reserva r WHERE (:startDate <= r.endDate AND :endDate >= r.startDate)")

    boolean existsByPeriodo(@Param("startDate")LocalDate startDate, @Param("endDate") LocalDate endDate);
}
