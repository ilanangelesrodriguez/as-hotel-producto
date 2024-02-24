package com.arquitectura.ashotelproducto.presentacion;

import com.arquitectura.ashotelproducto.dominio.Validador;
import com.arquitectura.ashotelproducto.dominio.login.LoginUsuario;
import com.arquitectura.ashotelproducto.dominio.login.Usuario;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.context.Flash;
import jakarta.inject.Named;

import java.sql.SQLException;

@Named
@RequestScoped
public class LoginBean {
    private String username;
    private String password;
    private Usuario usuario;
    private Validador validador = new Validador();

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

    public Usuario getUsuario() {
        return usuario;
    }

    public boolean isRequired() {
        return true;
    }

    public String getUsernameRequiredMessage() {
        return validador.usuarioRequerido();
    }

    public String getPasswordRequiredMessage() {
        return validador.contrasenaRequerida();
    }

    public String login() {
        FacesContext context = FacesContext.getCurrentInstance();
        Flash flash = context.getExternalContext().getFlash();

        try {
            LoginUsuario loginUsuario = LoginUsuario.getInstance();
            int authResult = loginUsuario.autenticar(username, password);
            if (authResult == 0) {
                usuario = loginUsuario.encontrarUsuario(username);
                String name = usuario.getName();
                context.getExternalContext().getSessionMap().put("name", name);
                usuario.mostrar();

                return "bienvenido";
            } else if (authResult == 1) {
                flash.setKeepMessages(true);
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error: La cuenta no existe.", "La cuenta no existe."));
                return "";
            } else {
                flash.setKeepMessages(true);
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error: Contraseña incorrecta.", "Contraseña incorrecta."));
                return "";
            }
        } catch (SQLException e) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error: No se pudo autenticar al usuario.", null));
            return "";
        }
    }

    public String logout() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "index?faces-redirect=true";
    }

}