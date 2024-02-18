package com.arquitectura.ashotelproducto.datos.estado;


import com.arquitectura.ashotelproducto.datos.CRUD;
import com.arquitectura.ashotelproducto.dominio.estado.Estado;

public interface EstadoDAO extends CRUD<Estado> {
    Estado selectByDescripcion(String estadoDescripcion);
}
