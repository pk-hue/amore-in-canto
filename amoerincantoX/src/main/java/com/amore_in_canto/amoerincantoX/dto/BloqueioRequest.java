package com.amore_in_canto.amoerincantoX.dto;

import java.time.LocalDate;

public class BloqueioRequest {
    private Long usuarioId;
    private LocalDate startDate;
    private LocalDate endDate;
    private String motivo;

    public Long getUsuarioId() {return usuarioId;}
    public void setUsuarioId(Long usuarioId) {this.usuarioId = usuarioId;}

    public LocalDate getStartDate() {return startDate;}
    public void setStartDate(LocalDate startDate) {this.startDate = startDate;}

    public LocalDate getEndDate() {return endDate;}
    public void setEndDate(LocalDate endDate) {this.endDate = endDate;}

    public String getMotivo() {return motivo;}
    public void setMotivo(String motivo) {this.motivo = motivo;}
}
