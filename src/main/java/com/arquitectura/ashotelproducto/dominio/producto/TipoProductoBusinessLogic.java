package com.arquitectura.ashotelproducto.dominio.producto;



import com.arquitectura.ashotelproducto.datos.producto.TipoProductoDAO;

import java.util.List;

public class TipoProductoBusinessLogic {

    TipoProductoDAO tipoProductoDAO;

    public TipoProductoBusinessLogic(TipoProductoDAO tipoProductoDAO) {
        this.tipoProductoDAO = tipoProductoDAO;
    }

    public void insertarTipoProducto(TipoProducto tipoProducto) {
        tipoProductoDAO.insert(tipoProducto);
    }

    public void actualizarTipoProducto(TipoProducto tipoProducto) {
        tipoProductoDAO.update(tipoProducto);
    }

    public void eliminarTipoProducto(TipoProducto tipoProducto) {
        tipoProductoDAO.delete(tipoProducto);
    }

    public TipoProducto obtenerTipoProducto(TipoProducto tipoProducto) {
        return tipoProductoDAO.select(tipoProducto);
    }

    public TipoProducto obtenerTipoProductoPorId(int id) {
        return tipoProductoDAO.selectById(id);
    }

    public List<TipoProducto> obtenerTodosLosTipoProductos() {
        return tipoProductoDAO.selectAll();
    }
}
