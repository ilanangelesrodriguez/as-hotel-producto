package com.arquitectura.ashotelproducto.dominio.turno;



import com.arquitectura.ashotelproducto.datos.otros.TurnoDAO;

import java.util.List;

public class TurnoBusinessLogic {
    TurnoDAO turnoDAO;

    public TurnoBusinessLogic(TurnoDAO turnoDAO) {
        this.turnoDAO = turnoDAO;
    }

    public void insertarTurno(Turno turno) {
        turnoDAO.insert(turno);
    }

    public void actualizarTurno(Turno turno) {
        turnoDAO.update(turno);
    }

    public void eliminarTurno(Turno turno) {
        turnoDAO.delete(turno);
    }

    public Turno obtenerTurno(Turno turno) {
        return turnoDAO.select(turno);
    }

    public Turno obtenerTurnoPorId(int id) {
        return turnoDAO.selectById(id);
    }

    public List<Turno> obtenerTodosLosTurno() {
        return turnoDAO.selectAll();
    }
}
