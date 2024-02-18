package com.arquitectura.ashotelproducto.dominio.habitacion;

import javax.persistence.*;

@Entity
@Table(name = "habitacion")
public class Habitacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_habitacion")
    private int idHabitacion;

    @Column(name = "id_tipohabitacion")
    private int idTipoHabitacion;

    @Column(name = "id_estado")
    private String estado;

    public Habitacion(int idHabitacion, int idTipohabitacion, String estado) {
        this.idHabitacion = idHabitacion;
        this.idTipoHabitacion = idTipohabitacion;
        this.estado = estado;
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
