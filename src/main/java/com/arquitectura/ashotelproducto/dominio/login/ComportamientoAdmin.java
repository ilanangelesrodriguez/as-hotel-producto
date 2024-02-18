package com.arquitectura.ashotelproducto.dominio.login;


import javax.swing.*;

/**
 * Implementación de la interfaz {@link ComportamientoRol} para el rol de Administrador.
 *
 * <p>Esta implementación muestra la ventana de inicio (FrmHome) cuando se invoca el método
 * {@link #mostrarFormulario()}.</p>
 *
 */

public class ComportamientoAdmin implements ComportamientoRol{

    @Override
    public void mostrarFormulario() {
        JOptionPane.showMessageDialog(null, "Esta sección esta en desarrollo.", "Información para el usuario", JOptionPane.INFORMATION_MESSAGE);


    }
}
