package com.amore_in_canto.amoerincantoX.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.amore_in_canto.amoerincantoX.domain.Usuario;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>, JpaSpecificationExecutor<Usuario>{
    Optional<Usuario> findByEmail(String email);
    boolean existsByEmail(String email);
}
