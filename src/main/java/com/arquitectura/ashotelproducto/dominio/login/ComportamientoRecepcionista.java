package com.arquitectura.ashotelproducto.dominio.login;


public class ComportamientoRecepcionista implements ComportamientoRol {
    private Usuario usuario;

    public ComportamientoRecepcionista(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public void mostrarFormulario() {

    }
}
