package com.arquitectura.ashotelproducto.datos.habitacion;


import com.arquitectura.ashotelproducto.datos.CRUD;
import com.arquitectura.ashotelproducto.dominio.habitacion.Habitacion;

public interface HabitacionDAO extends CRUD<Habitacion> {
    Habitacion selectByDescripcion(String habitacionDescripcion);
}
