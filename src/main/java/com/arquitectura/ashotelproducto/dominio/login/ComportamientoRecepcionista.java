package com.arquitectura.ashotelproducto.dominio.login;

import jakarta.faces.context.ExternalContext;
import jakarta.faces.context.FacesContext;

import java.io.IOException;

public class ComportamientoRecepcionista implements ComportamientoRol {
    private Usuario usuario;

    public ComportamientoRecepcionista(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public void mostrarFormulario() {
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        try {
            externalContext.redirect("menu.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}