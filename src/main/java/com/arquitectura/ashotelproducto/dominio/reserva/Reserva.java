package com.arquitectura.ashotelproducto.dominio.reserva;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.Date;

@Entity
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idReserva;
    private int idHabitacion;
    private int idCliente;
    private int idTurno;
    private String idTipoReserva;
    private Date fechaIngreso;
    private int cantidadPersonas;
    private Date fechaFin;
    private String estado;

public Reserva(int idReserva, int idHabitacion, int idCliente, int idTurno, String idTipoReserva, Timestamp fechaIngreso, int cantidadPersonas, Timestamp fechaFin, String estado) {
    this.idReserva = idReserva;
    this.idHabitacion = idHabitacion;
    this.idCliente = idCliente;
    this.idTurno = idTurno;
    this.idTipoReserva = idTipoReserva;
    this.fechaIngreso = fechaIngreso;
    this.cantidadPersonas = cantidadPersonas;
    this.fechaFin = fechaFin;
    this.estado = estado;
}

    // Getters and Setters
    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public int getIdHabitacion() {
        return idHabitacion;
    }

    public void setIdHabitacion(int idHabitacion) {
        this.idHabitacion = idHabitacion;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdTurno() {
        return idTurno;
    }

    public void setIdTurno(int idTurno) {
        this.idTurno = idTurno;
    }

    public String getIdTipoReserva() {
        return idTipoReserva;
    }

    public void setIdTipoReserva(String idTipoReserva) {
        this.idTipoReserva = idTipoReserva;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public int getCantidadPersonas() {
        return cantidadPersonas;
    }

    public void setCantidadPersonas(int cantidadPersonas) {
        this.cantidadPersonas = cantidadPersonas;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
