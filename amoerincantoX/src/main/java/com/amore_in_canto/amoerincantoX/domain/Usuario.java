package com.amore_in_canto.amoerincantoX.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.amore_in_canto.amoerincantoX.domain.enums.UserRole;
import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collections;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Builder
@Entity @Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Table(name = "cliente")
public class Usuario implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(unique = true, nullable = false, length = 250)
    private String email;

    @JsonIgnore
    @Column(nullable = false, length = 150)
    private String password;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private UserRole role;

    @JsonIgnore
    @Column(nullable = false, name = "created_at")
    private LocalDateTime createdAt;

    @JsonIgnore
    @OneToMany(mappedBy = "usuario")
    private List<Reserva> reservas = new ArrayList();

    @JsonIgnore
    @OneToMany(mappedBy = "usuario")
    private List<Bloqueio> bloqueios = new ArrayList();

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities(){
        if(this.role == UserRole.ADMIN){
            return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"), new SimpleGrantedAuthority("ROLE_USER"));
        }
        return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }


    @Override
    public String getUsername() { return this.email; }

    @Override
    public boolean isAccountNonExpired() { return true; }

    @Override
    public boolean isAccountNonLocked() { return true; }

    @Override
    public boolean isCredentialsNonExpired() { return true; }

    @Override
    public boolean isEnabled() { return true; }


    @PrePersist
    public void onCreate(){
        this.createdAt = LocalDateTime.now();
    }
}
