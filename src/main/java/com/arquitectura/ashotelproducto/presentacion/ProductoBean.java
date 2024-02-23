package com.arquitectura.ashotelproducto.presentacion;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

@Named
@RequestScoped
public class ProductoBean {
    public String crear() {
        return "crearProducto";
    }

    public String leer() {
        return "leerProducto";
    }

    public String actualizar() {
        return "actualizarProducto";
    }

    public String eliminar() {
        return "eliminarProducto";
    }
}
