package com.arquitectura.ashotelproducto.dominio.reserva;



import com.arquitectura.ashotelproducto.datos.reserva.TipoReservaDAO;

import java.util.List;

public class TipoReservaBusinessLogic {
    TipoReservaDAO tipoReservaDAO;

    public TipoReservaBusinessLogic(TipoReservaDAO tipoReservaDAO) {
        this.tipoReservaDAO = tipoReservaDAO;
    }

    public void insertarTipoReserva(TipoReserva tipoReserva) {
        tipoReservaDAO.insert(tipoReserva);
    }

    public void actualizarTipoReserva(TipoReserva tipoReserva) {
        tipoReservaDAO.update(tipoReserva);
    }

    public void eliminarTipoReserva(TipoReserva tipoReserva) {
        tipoReservaDAO.delete(tipoReserva);
    }

    public TipoReserva obtenerTipoReserva(TipoReserva tipoReserva) {
        return tipoReservaDAO.select(tipoReserva);
    }

    public TipoReserva obtenerTipoReservaPorId(int id) {
        return tipoReservaDAO.selectById(id);
    }

    public List<TipoReserva> obtenerTodosLosTipoReserva() {
        return tipoReservaDAO.selectAll();
    }
}
