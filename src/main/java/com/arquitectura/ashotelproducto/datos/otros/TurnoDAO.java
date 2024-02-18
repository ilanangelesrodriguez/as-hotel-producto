package com.arquitectura.ashotelproducto.datos.otros;


import com.arquitectura.ashotelproducto.datos.CRUD;
import com.arquitectura.ashotelproducto.dominio.turno.Turno;

public interface TurnoDAO extends CRUD<Turno> {
    Turno selectByNombre(String turnoNombre);
}
