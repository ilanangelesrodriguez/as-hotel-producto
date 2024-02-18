package com.arquitectura.ashotelproducto.dominio.habitacion;



import com.arquitectura.ashotelproducto.datos.habitacion.HabitacionDAO;

import java.util.List;

public class HabitacionBusinessLogic {
    private final HabitacionDAO habitacionDAO;

    public HabitacionBusinessLogic(HabitacionDAO habitacionDAO) {
        this.habitacionDAO = habitacionDAO;
    }

    public void insertarHabitacion(Habitacion habitacion) {
        habitacionDAO.insert(habitacion);
    }

    public void actualizarHabitacion(Habitacion habitacion) {
        habitacionDAO.update(habitacion);
    }

    public void eliminarHabitacion(Habitacion habitacion) {
        habitacionDAO.delete(habitacion);
    }

    public Habitacion obtenerHabitacion(Habitacion habitacion) {
        return habitacionDAO.select(habitacion);
    }

    public Habitacion obtenerHabitacionPorId(int id) {
        return habitacionDAO.selectById(id);
    }

    public List<Habitacion> obtenerTodasLasHabitaciones() {
        return habitacionDAO.selectAll();
    }

}
