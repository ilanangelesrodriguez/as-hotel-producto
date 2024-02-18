package com.arquitectura.ashotelproducto.datos.producto;


import com.arquitectura.ashotelproducto.datos.CRUD;
import com.arquitectura.ashotelproducto.dominio.producto.Producto;

public interface ProductoDAO extends CRUD<Producto> {
    public int getLastId();
}
