package com.arquitectura.ashotelproducto.dominio.habitacion;

import javax.persistence.*;

@Entity
@Table(name = "tipo_habitacion")
public class TipoHabitacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipohabitacion")
    private int idTipoHabitacion;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "id_costohabitacion")
    private int idCostoHabitacion;

    @Column(name = "costo")
    private float costo;

    public TipoHabitacion(int idTipohabitacion, String descripcion) {
        this.idTipoHabitacion = idTipohabitacion;
        this.descripcion = descripcion;
    }

    public int getIdTipoHabitacion() {
        return idTipoHabitacion;
    }

    public void setIdTipoHabitacion(int idTipoHabitacion) {
        this.idTipoHabitacion = idTipoHabitacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getIdCostoHabitacion() {
        return idCostoHabitacion;
    }

    public void setIdCostoHabitacion(int idCostoHabitacion) {
        this.idCostoHabitacion = idCostoHabitacion;
    }

    public float getCosto() {
        return costo;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }
}
