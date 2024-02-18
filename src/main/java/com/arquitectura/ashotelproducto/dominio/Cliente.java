package com.arquitectura.ashotelproducto.dominio;

public class Cliente {
    private int idCliente;
    private String dni;

    public Cliente(int idCliente, String dni) {
        this.idCliente = idCliente;
        this.dni = dni;
    }

    public Cliente(String dni) {
        this.dni = dni;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }
}
