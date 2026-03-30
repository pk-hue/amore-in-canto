package com.amore_in_canto.amoerincantoX.domain;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Builder
@Entity @Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Table(name = "cliente")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(unique = true, nullable = false, length = 250)
    private String email;

    @Column(nullable = false, length = 150)
    private String password;

    @JsonIgnore
    @Column(nullable = false, name = "created_at")
    private LocalDateTime createdAt;

    @JsonIgnore
    @OneToMany(mappedBy = "usuario")
    private List<Reserva> reservas = new ArrayList();

    @PrePersist
    public void onCreate(){
        this.createdAt = LocalDateTime.now();
    }
}
