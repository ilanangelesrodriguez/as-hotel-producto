package com.arquitectura.ashotelproducto.dominio.habitacion;



import com.arquitectura.ashotelproducto.datos.habitacion.TipoHabitacionDAO;

import java.util.List;

public class TipoHabitacionBusinessLogic {

    private final TipoHabitacionDAO tipoHabitacionDAO;

    public TipoHabitacionBusinessLogic(TipoHabitacionDAO tipoHabitacionDAO) {
        this.tipoHabitacionDAO = tipoHabitacionDAO;
    }

    public void insertarTipoHabitacion(TipoHabitacion tipoHabitacion) {
        tipoHabitacionDAO.insert(tipoHabitacion);
    }

    public void actualizarTipoHabitacion(TipoHabitacion tipoHabitacion) {
        tipoHabitacionDAO.update(tipoHabitacion);
    }

    public void eliminarTipoHabitacion(TipoHabitacion tipoHabitacion) {
        tipoHabitacionDAO.delete(tipoHabitacion);
    }

    public TipoHabitacion obtenerTipoHabitacion(TipoHabitacion tipoHabitacion) {
        return tipoHabitacionDAO.select(tipoHabitacion);
    }

    public TipoHabitacion obtenerTipoHabitacionPorId(int id) {
        return tipoHabitacionDAO.selectById(id);
    }

    public List<TipoHabitacion> obtenerTodosLosTiposDeHabitacion() {
        return tipoHabitacionDAO.selectAll();
    }
}
