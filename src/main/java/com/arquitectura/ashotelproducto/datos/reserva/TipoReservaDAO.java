package com.arquitectura.ashotelproducto.datos.reserva;


import com.arquitectura.ashotelproducto.datos.CRUD;
import com.arquitectura.ashotelproducto.dominio.reserva.TipoReserva;

public interface TipoReservaDAO extends CRUD<TipoReserva> {
    TipoReserva selectByDescripcion(String tipoReservaDescripcion);
    // No additional methods
}
