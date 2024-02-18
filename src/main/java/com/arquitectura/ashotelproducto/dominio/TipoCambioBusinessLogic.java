package com.arquitectura.ashotelproducto.dominio;


import com.arquitectura.ashotelproducto.datos.otros.TipoCambioDAO;

public class TipoCambioBusinessLogic {
    TipoCambioDAO tipoCambioDAO;

    public TipoCambioBusinessLogic(TipoCambioDAO tipoCambioDAO) {
        this.tipoCambioDAO = tipoCambioDAO;
    }

    public void insertarTipoCambio(TipoCambio tipoCambio) {
        tipoCambioDAO.insert(tipoCambio);
    }

    public void actualizarTipoCambio(TipoCambio tipoCambio) {
        tipoCambioDAO.update(tipoCambio);
    }

    public void eliminarTipoCambio(TipoCambio tipoCambio) {
        tipoCambioDAO.delete(tipoCambio);
    }

    public TipoCambio obtenerTipoCambio(TipoCambio tipoCambio) {
        return tipoCambioDAO.select(tipoCambio);
    }

    public TipoCambio obtenerTipoCambioPorId(int id) {
        return tipoCambioDAO.selectById(id);
    }
}
