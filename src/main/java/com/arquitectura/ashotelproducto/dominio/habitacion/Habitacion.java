package com.arquitectura.ashotelproducto.dominio.habitacion;


public class Habitacion {
    private int idHabitacion;

    private int idTipoHabitacion;

    private String estado;

    public Habitacion(int idHabitacion, int idTipohabitacion, String estado) {
        this.idHabitacion = idHabitacion;
        this.idTipoHabitacion = idTipohabitacion;
        this.estado = estado;
    }

    public Habitacion() {

    }

    public int getIdHabitacion() {
        return idHabitacion;
    }

    public void setIdHabitacion(int idHabitacion) {
        this.idHabitacion = idHabitacion;
    }

    public int getIdTipoHabitacion() {
        return idTipoHabitacion;
    }

    public void setIdTipoHabitacion(int idTipoHabitacion) {
        this.idTipoHabitacion = idTipoHabitacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
