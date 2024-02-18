package com.arquitectura.ashotelproducto.dominio.reserva;



import com.arquitectura.ashotelproducto.datos.reserva.ReservaDAO;

import java.util.List;

public class ReservaBusinessLogic {
    public ReservaDAO reservaDAO;
    ReservaBusinessLogic(ReservaDAO reservaDAO) {
        this.reservaDAO = reservaDAO;
    }
    public void guardarReserva(Reserva reserva) {
        reservaDAO.insert(reserva);
    }

    public void actualizarReserva(Reserva reserva) {
        reservaDAO.update(reserva);
    }

    public void eliminarReserva(int id) {
        Reserva reserva = reservaDAO.selectById(id);
        if (reserva != null) {
            reservaDAO.delete(reserva);
        }
    }

    public Reserva buscarReservaPorId(int id) {
        return reservaDAO.selectById(id);
    }

    public Reserva buscarReserva(Reserva reserva) {
        return reservaDAO.select(reserva);
    }

    public List<Reserva> buscarTodasReservas() {
        return reservaDAO.selectAll();
    }
}
