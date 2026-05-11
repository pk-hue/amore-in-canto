package com.amore_in_canto.amoerincantoX.controller;

import com.amore_in_canto.amoerincantoX.domain.Reserva;
import com.amore_in_canto.amoerincantoX.domain.Usuario;
import com.amore_in_canto.amoerincantoX.domain.enums.Status;
import com.amore_in_canto.amoerincantoX.dto.ReservaRequest;
import com.amore_in_canto.amoerincantoX.service.ReservaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/usuarios/reservas")
public class ReservaController {

    private final ReservaService reservaService;

    public ReservaController(ReservaService reservaService) {this.reservaService = reservaService;}

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Reserva> cadastrarReserva(@RequestBody ReservaRequest request){
        Reserva reserva = reservaService.cadastrarReserva(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(reserva);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Reserva>> ListarPorUsuario(@PathVariable Long id){
        List<Reserva> reservas = reservaService.ListarReservasPorUsuario(id);
        return ResponseEntity.ok(reservas);
    }

    @PatchMapping("/{id}/aprovar")
    public ResponseEntity<Reserva> aprovarReserva(@PathVariable Long id){
        Reserva reservaAprovada = reservaService.aprovarReserva(id);
        return ResponseEntity.ok(reservaAprovada);
    }

    @PatchMapping("/{id}/recusar")
    public ResponseEntity<Reserva> recusarReserva(@PathVariable Long id){
        Reserva reservaRecusada = reservaService.recusarReserva(id);
        return ResponseEntity.ok(reservaRecusada);
    }
}
