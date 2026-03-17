package com.amore_in_canto.amoerincantoX.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Builder
@Entity @Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Table(name = "cliente")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(unique = true, nullable = false, length = 250)
    private String email;

    @Column(nullable = false, length = 150)
    private String password;

    @Column(nullable = false, name = "created_at")
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "usuario")
    private List<Reserva> reservas;

    @PrePersist
    public void onCreate(){
        this.createdAt = LocalDateTime.now();
    }
}
