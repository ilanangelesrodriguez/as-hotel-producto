package com.arquitectura.ashotelproducto.datos.otros;


import com.arquitectura.ashotelproducto.datos.CRUD;
import com.arquitectura.ashotelproducto.dominio.TipoCambio;

public interface TipoCambioDAO extends CRUD<TipoCambio> {
    int getIdByMonedaDestino(String tipoCambioSeleccionado);
}
