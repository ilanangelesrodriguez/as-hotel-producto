package com.arquitectura.ashotelproducto.dominio.login;

/**
 * Interfaz que define el comportamiento asociado a un determinado rol en el sistema.
 *
 * <p>Cada implementación de esta interfaz proporciona la lógica específica para mostrar el formulario
 * correspondiente a un rol particular.</p>
 *
 * <p>Implementado por clases como {@link ComportamientoAdmin} y {@link ComportamientoRecepcionista}.</p>
 *
 */

public interface ComportamientoRol {
    void mostrarFormulario();

}
