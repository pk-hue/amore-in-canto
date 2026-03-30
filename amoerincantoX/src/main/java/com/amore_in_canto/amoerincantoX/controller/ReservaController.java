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
@RequestMapping("/usuarios/{usuarioId}/reservas")
public class ReservaController {

    private final ReservaService reservaService;

    public ReservaController(ReservaService reservaService) {this.reservaService = reservaService;}

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Reserva> cadastrarReserva(@RequestBody ReservaRequest request){
        Reserva reserva = reservaService.cadastrarReserva(request.getUsuarioId(), request.getStartDate(), request.getEndDate(), request.getStatus());
        System.out.println(request.getStatus());
        return ResponseEntity.status(HttpStatus.CREATED).body(reserva);
    }

    @GetMapping
    public ResponseEntity<List<Reserva>> listarReservas(){
        List<Reserva> reservas = reservaService.ListarReservas();
        return ResponseEntity.ok(reservas);
    }
}
