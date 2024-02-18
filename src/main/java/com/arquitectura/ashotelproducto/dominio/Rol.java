package com.arquitectura.ashotelproducto.dominio;


/**
 * Clase que representa un rol en el sistema.
 *
 * <p>Un rol tiene un nombre que lo identifica y un estado que indica su situación actual.</p>
 *
 */
public class Rol {
    private String nombre;

    public Rol(int idRol, String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }



}
