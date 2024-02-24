package com.arquitectura.ashotelproducto.datos.cliente;


import com.arquitectura.ashotelproducto.datos.CRUD;
import com.arquitectura.ashotelproducto.dominio.Cliente;

public interface ClienteDAO extends CRUD<Cliente> {
    Cliente buscarPorDni(String dni);
}
