package com.arquitectura.ashotelproducto.presentacion;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;


@Named
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
        if (username == null || username.trim().isEmpty() || password == null || password.trim().isEmpty()) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Por favor, complete todos los campos."));
            return null; // Permanece en la misma página
        }

        if ("usuario".equals(username) && "contrasena".equals(password)) {
            return "bienvenido"; // Nombre de la página de bienvenida
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Nombre de usuario o contraseña incorrectos."));
            return null; // Permanece en la misma página
        }
    }
}