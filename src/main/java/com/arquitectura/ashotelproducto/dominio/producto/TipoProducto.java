package com.arquitectura.ashotelproducto.dominio.producto;

public class TipoProducto {
    private int idTipoProducto;
    private String descripcion;

    // Getters and Setters
    public int getIdTipoProducto() {
        return idTipoProducto;
    }

    public void setIdTipoProducto(int idTipoProducto) {
        this.idTipoProducto = idTipoProducto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}