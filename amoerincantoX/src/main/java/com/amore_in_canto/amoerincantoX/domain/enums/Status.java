package com.amore_in_canto.amoerincantoX.domain.enums;

public enum Status {
    REQUESTED, // <- cliente pediu reserva e a banda ainda não aceitou
    APPROVED, // <- banda aceitou e data fica bloqueada
    REJECTED, // <- banda recusou
    CANCELLED, // <- cliente cancelou
    EXPIRED; // <- pedido ficou muito tempo sem respota (ex: 48h)
}
