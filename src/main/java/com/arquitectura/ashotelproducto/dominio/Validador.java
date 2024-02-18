package com.arquitectura.ashotelproducto.dominio;


import com.arquitectura.ashotelproducto.dominio.login.Usuario;

import javax.swing.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Clase que proporciona métodos para validar información, como nombres de usuario y contraseñas,
 * y para mostrar mensajes de error o éxito.
 *
 */
public class Validador {

    public boolean validarNombreUsuario(String nombreUsuario, Usuario usuario) {
         // Lógica de validación del nombre de usuario
        boolean nombreUsuarioValido = !nombreUsuario.isEmpty();

        if (!nombreUsuarioValido) {
            mostrarMensajeError("El nombre de usuario no puede estar vacío.");
        }

        return nombreUsuarioValido;
    }

    public boolean validarContrasena(char[] contrasena) {
        // Lógica de validación de la contraseña
        String patron = "^[a-z0-9]+$";
        String password=new String(contrasena);
        Pattern pattern = Pattern.compile(patron);
        Matcher matcher = pattern.matcher(password);

        Boolean charvalido=matcher.matches();
        boolean contrasenaValida = contrasena.length == 6;
        
        if (!contrasenaValida) {
            mostrarMensajeError("La contraseña debe tener al menos 6 caracteres.");
        }else if(!charvalido){
            mostrarMensajeError("La contraseña debe tener letras minusculas y números");
        }

        return contrasenaValida && charvalido;
    }

    public void mostrarMensajeError(String mensaje) {
        // Método para mostrar mensajes de error (puedes usar JOptionPane o cualquier otro método de tu elección)
        JOptionPane.showMessageDialog(null, "Error: " + mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }

    public void mostrarMensajeCorrecto(String mensaje) {
        // Método para mostrar mensajes de éxito o correctos
        JOptionPane.showMessageDialog(null, mensaje, "Éxito", JOptionPane.INFORMATION_MESSAGE);
    }
    
}
