package com.arquitectura.ashotelproducto.dominio.login;


import com.arquitectura.ashotelproducto.dominio.Rol;

/**
 *
 *  Clase que representa a un usuario en el sistema.
 *
 *  <p>Esta clase incluye información básica sobre un usuario, como su nombre de usuario,
 *  contraseña y estado actual. Además, registra el número de intentos de inicio de sesión fallidos
 *  y la fecha de bloqueo en caso de exceder los intentos permitidos.</p>
 *
 */
public class Usuario {
    private String name;
    private String lastName;
    private String username;

    private String password;

    private Rol rol;

    private ComportamientoRol comportamientoRol;

    public Usuario(String username,Rol rol, String password) {
        this.username = username;
        this.password = password;
        this.rol=rol;
        this.comportamientoRol = obtenerComportamiento(rol);
    }

    private ComportamientoRol obtenerComportamiento(Rol rol) {
        if (rol.getNombre().equals("admin")) {
            return new ComportamientoAdmin();
        } else if (rol.getNombre().equals("recepcionista")) {
            return new ComportamientoRecepcionista(this);
        } else {
            return null;
        }
    }

    public void establecerComportamiento(ComportamientoRol comportamientoRol) {
        this.comportamientoRol = comportamientoRol;
    }

    public String getInformacionUsuario() {
        return getName() + " " + getLastName();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void mostrar() {
        comportamientoRol.mostrarFormulario();
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
