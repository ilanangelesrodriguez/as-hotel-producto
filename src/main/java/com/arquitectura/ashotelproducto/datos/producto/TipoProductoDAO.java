package com.arquitectura.ashotelproducto.datos.producto;


import com.arquitectura.ashotelproducto.datos.CRUD;
import com.arquitectura.ashotelproducto.dominio.producto.TipoProducto;

import java.util.List;

public interface TipoProductoDAO extends CRUD<TipoProducto> {
    List<String> getAllDescriptions();

    int getIdByDescription(String tipoProductoSeleccionado);
}
