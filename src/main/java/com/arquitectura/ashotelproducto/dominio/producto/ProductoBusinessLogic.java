package com.arquitectura.ashotelproducto.dominio.producto;



import com.arquitectura.ashotelproducto.datos.producto.ProductoDAO;

import java.util.List;

public class ProductoBusinessLogic {
    private ProductoDAO productoDAO;

    public ProductoBusinessLogic(ProductoDAO productoDAO) {
        this.productoDAO = productoDAO;
    }

    public void insertarProducto(Producto producto) {
        productoDAO.insert(producto);
    }

    public void actualizarProducto(Producto producto) {
        productoDAO.update(producto);
    }

    public void eliminarProducto(Producto producto) {
        productoDAO.delete(producto);
    }

    public Producto obtenerProducto(Producto producto) {
        return productoDAO.select(producto);
    }

    public Producto obtenerProductoPorId(int id) {
        return productoDAO.selectById(id);
    }

    public List<Producto> obtenerTodosLosProductos() {
        return productoDAO.selectAll();
    }
}
