package com.amore_in_canto.amoerincantoX.dto;

import com.amore_in_canto.amoerincantoX.domain.enums.Status;
import java.time.LocalDate;

public class ReservaRequest {
    private Long usuarioId;
    private LocalDate startDate;
    private LocalDate endDate;
    private Status status;

    public Long getUsuarioId() {return usuarioId;}
    public void setUsuarioId(Long usuarioId) {this.usuarioId = usuarioId;}

    public LocalDate getStartDate() {return startDate;}
    public void setStartDate(LocalDate startDate) {this.startDate = startDate;}

    public LocalDate getEndDate() {return endDate;}
    public void setEndDate(LocalDate endDate) {this.endDate = endDate;}

    public Status getStatus() {return status;}
    public void setStatus(Status status) {this.status = status;}
}
