package com.arquitectura.ashotelproducto.presentacion;

import com.arquitectura.ashotelproducto.datos.otros.TipoCambioDAOImpl;
import com.arquitectura.ashotelproducto.datos.producto.ProductoDAO;
import com.arquitectura.ashotelproducto.datos.producto.ProductoDAOImpl;
import com.arquitectura.ashotelproducto.datos.producto.TipoProductoDAOImpl;
import com.arquitectura.ashotelproducto.dominio.TipoCambio;
import com.arquitectura.ashotelproducto.dominio.TipoCambioBusinessLogic;
import com.arquitectura.ashotelproducto.dominio.producto.Producto;
import com.arquitectura.ashotelproducto.dominio.producto.ProductoBusinessLogic;
import com.arquitectura.ashotelproducto.dominio.producto.TipoProducto;
import com.arquitectura.ashotelproducto.dominio.producto.TipoProductoBusinessLogic;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Named
@RequestScoped
public class ProductoBean {
    private Producto producto;
    private ProductoBusinessLogic productoBL;
    private List<TipoProducto> tiposProducto;
    private List<TipoCambio> tiposCambio;
    private List<Producto> productos;

    // En ProductoBean
    public ProductoBean() throws SQLException {
        producto = new Producto();
        productoBL = new ProductoBusinessLogic(new ProductoDAOImpl());
        TipoProductoBusinessLogic tipoProductoBL = new TipoProductoBusinessLogic(new TipoProductoDAOImpl());
        TipoCambioBusinessLogic tipoCambioBL = new TipoCambioBusinessLogic(new TipoCambioDAOImpl());

        List<Producto> todosLosProductos = productoBL.obtenerTodosLosProductos();
        productos = todosLosProductos;
        if (!todosLosProductos.isEmpty()) {
            Producto ultimoProducto = todosLosProductos.stream()
                    .max(Comparator.comparing(Producto::getIdProducto))
                    .orElseThrow(SQLException::new);
            producto.setIdProducto(ultimoProducto.getIdProducto() + 1);
        } else {
            producto.setIdProducto(1); // Valor predeterminado si no hay productos en la base de datos
        }

        producto.setIdTipoProducto(1); // Esto se llenará en la vista
        producto.setNombre("");
        producto.setPrecio(0);
        producto.setIdTipoCambio(1); // Esto se llenará en la vista

        // Asignar las listas obtenidas a las variables de instancia
        this.tiposProducto = tipoProductoBL.obtenerTodosLosTipoProductos();
        this.tiposCambio = tipoCambioBL.obtenerTodosLosTipoCambios();
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public List<TipoProducto> getTiposProducto() {
        return tiposProducto;
    }

    public void setTiposProducto(List<TipoProducto> tiposProducto) {
        this.tiposProducto = tiposProducto;
    }

    public List<TipoCambio> getTiposCambio() {
        return tiposCambio;
    }

    public void setTiposCambio(List<TipoCambio> tiposCambio) {
        this.tiposCambio = tiposCambio;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public String ingresar() {
        productoBL.insertarProducto(producto);
        return "success";
    }
    public void buscar() {
        if (producto.getIdProducto() == 0) {
            productos = productoBL.obtenerTodosLosProductos();
        } else {
            Producto productoBuscado = productoBL.obtenerProductoPorId(producto.getIdProducto());
            productos = new ArrayList<>();
            if (productoBuscado != null) {
                productos.add(productoBuscado);
            }
        }
    }

    public String cargarProducto(Producto producto) {
        this.producto = producto;
        return "editar-producto";
    }

    public String eliminarProducto(int idProducto) {
        Producto productoAEliminar = productoBL.obtenerProductoPorId(idProducto);
        if (productoAEliminar != null) {
            productoBL.eliminarProducto(productoAEliminar);
        }
        return "buscar-producto";
    }

    public String crear() {
        return "crearProducto";
    }

    public String leer() {
        return "leerProducto";
    }

    public String actualizar() {
        return "actualizarProducto";
    }

    public String eliminar() {
        return "eliminarProducto";
    }
}
