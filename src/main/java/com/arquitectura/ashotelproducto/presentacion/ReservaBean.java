package com.arquitectura.ashotelproducto.presentacion;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

@Named
@RequestScoped
public class ReservaBean {

    public String crear() {
        return "crearReserva";
    }

    public String leer() {
        return "leerReserva";
    }

    public String actualizar() {
        return "actualizarReserva";
    }

    public String eliminar() {
        return "eliminarReserva";
    }
}
