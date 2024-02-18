package com.arquitectura.ashotelproducto.datos.producto;


import com.arquitectura.ashotelproducto.datos.conexion.Conexion;
import com.arquitectura.ashotelproducto.datos.conexion.ConexionMySQL;
import com.arquitectura.ashotelproducto.dominio.producto.Producto;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAOImpl implements ProductoDAO {
    private final Conexion conexion;

    public ProductoDAOImpl() throws SQLException {
        this.conexion = new ConexionMySQL();
    }

    @Override
    public void insert(Producto producto) {
        String sql = "INSERT INTO hostal.producto (id_tipoproducto, nombre, precio, id_tipo_cambio) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = conexion.obtenerConexion().prepareStatement(sql)) {
            stmt.setInt(1, producto.getIdTipoProducto());
            stmt.setString(2, producto.getNombre());
            stmt.setFloat(3, producto.getPrecio());
            stmt.setInt(4, producto.getIdTipoCambio());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Producto producto) {
        String sql = "UPDATE hostal.producto SET id_tipoproducto = ?, nombre = ?, precio = ?, id_tipo_cambio = ? WHERE id_producto = ?";
        try (PreparedStatement stmt = conexion.obtenerConexion().prepareStatement(sql)) {
            stmt.setInt(1, producto.getIdTipoProducto());
            stmt.setString(2, producto.getNombre());
            stmt.setFloat(3, producto.getPrecio());
            stmt.setInt(4, producto.getIdTipoCambio());
            stmt.setInt(5, producto.getIdProducto());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Producto producto) {
        String sql = "DELETE FROM hostal.producto WHERE id_producto = ?";
        try (PreparedStatement stmt = conexion.obtenerConexion().prepareStatement(sql)) {
            stmt.setInt(1, producto.getIdProducto());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Producto select(Producto producto) {
        Producto result = null;
        String sql = "SELECT * FROM hostal.producto WHERE id_producto = ?";
        try (PreparedStatement stmt = conexion.obtenerConexion().prepareStatement(sql)) {
            stmt.setInt(1, producto.getIdProducto());
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                result = new Producto();
                result.setIdProducto(rs.getInt("id_producto"));
                result.setIdTipoProducto(rs.getInt("id_tipoproducto"));
                result.setNombre(rs.getString("nombre"));
                result.setPrecio(rs.getFloat("precio"));
                result.setIdTipoCambio(rs.getInt("id_tipo_cambio"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Producto selectById(int id) {
        Producto result = null;
        String sql = "SELECT * FROM hostal.producto WHERE id_producto = ?";
        try (PreparedStatement stmt = conexion.obtenerConexion().prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                result = new Producto();
                result.setIdProducto(rs.getInt("id_producto"));
                result.setIdTipoProducto(rs.getInt("id_tipoproducto"));
                result.setNombre(rs.getString("nombre"));
                result.setPrecio(rs.getFloat("precio"));
                result.setIdTipoCambio(rs.getInt("id_tipo_cambio"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<Producto> selectAll() {
        List<Producto> result = new ArrayList<>();
        String sql = "SELECT * FROM hostal.producto";
        try (PreparedStatement stmt = conexion.obtenerConexion().prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Producto producto = new Producto();
                producto.setIdProducto(rs.getInt("id_producto"));
                producto.setIdTipoProducto(rs.getInt("id_tipoproducto"));
                producto.setNombre(rs.getString("nombre"));
                producto.setPrecio(rs.getFloat("precio"));
                producto.setIdTipoCambio(rs.getInt("id_tipo_cambio"));
                result.add(producto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int getLastId() {
        int lastId = 0;
        String sql = "SELECT MAX(id_producto) as last_id FROM hostal.producto";
        try (PreparedStatement stmt = conexion.obtenerConexion().prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                lastId = rs.getInt("last_id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lastId;
    }
}