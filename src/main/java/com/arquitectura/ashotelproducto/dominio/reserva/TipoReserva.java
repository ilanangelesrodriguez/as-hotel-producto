package com.arquitectura.ashotelproducto.dominio.reserva;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TipoReserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTipoReserva;
    private String descripcion;

    public TipoReserva(int idTipoReserva, String descripcion) {
        this.idTipoReserva = idTipoReserva;
        this.descripcion = descripcion;
    }

    // Getters and Setters

    public int getIdTipoReserva() {
        return idTipoReserva;
    }

    public void setIdTipoReserva(int idTipoReserva) {
        this.idTipoReserva = idTipoReserva;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
