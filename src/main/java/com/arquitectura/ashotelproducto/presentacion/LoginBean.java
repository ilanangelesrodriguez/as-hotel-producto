package com.arquitectura.ashotelproducto.presentacion;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "loginBean")
@RequestScoped
public class LoginBean {
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String login() {
        if ("usuario".equals(username) && "contrasena".equals(password)) {
            return "bienvenido"; // Nombre de la página de bienvenida
        } else {
            return "error"; // Nombre de la página de error de inicio de sesión
        }
    }
}