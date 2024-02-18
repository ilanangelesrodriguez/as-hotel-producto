package com.arquitectura.ashotelproducto.datos.reserva;


import com.arquitectura.ashotelproducto.datos.CRUD;
import com.arquitectura.ashotelproducto.dominio.reserva.Reserva;

public interface ReservaDAO extends CRUD<Reserva> {
    Reserva selectById(int id);
}
