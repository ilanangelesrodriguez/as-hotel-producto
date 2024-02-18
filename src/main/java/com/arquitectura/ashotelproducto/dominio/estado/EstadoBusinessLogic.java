package com.arquitectura.ashotelproducto.dominio.estado;


import com.arquitectura.ashotelproducto.datos.estado.EstadoDAO;

import java.util.List;

public class EstadoBusinessLogic {
    public EstadoDAO estadoDAO;

    public EstadoBusinessLogic(EstadoDAO estadoDAO) {
        this.estadoDAO = estadoDAO;
    }

    public void guardarEstado(Estado estado) {
        estadoDAO.insert(estado);
    }

    public void actualizarEstado(Estado estado) {
        estadoDAO.update(estado);
    }

    public void eliminarEstado(int id) {
        Estado estado = estadoDAO.selectById(id);
        if (estado != null) {
            estadoDAO.delete(estado);
        }
    }

    public Estado buscarEstadoPorId(int id) {
        return estadoDAO.selectById(id);
    }

    public Estado buscarEstado(Estado estado) {
        return estadoDAO.select(estado);
    }

    public List<Estado> buscarTodosEstados() {
        return estadoDAO.selectAll();
    }
}
