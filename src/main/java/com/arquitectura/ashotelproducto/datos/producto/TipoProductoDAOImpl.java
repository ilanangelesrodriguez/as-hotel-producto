package com.arquitectura.ashotelproducto.datos.producto;


import com.arquitectura.ashotelproducto.datos.conexion.Conexion;
import com.arquitectura.ashotelproducto.datos.conexion.ConexionMySQL;
import com.arquitectura.ashotelproducto.dominio.producto.TipoProducto;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TipoProductoDAOImpl implements TipoProductoDAO {
    private final Conexion conexion;

    public TipoProductoDAOImpl() throws SQLException {
        this.conexion = new ConexionMySQL();
    }

    @Override
    public void insert(TipoProducto tipoProducto) {
        String sql = "INSERT INTO hostal.tipo_producto (descripcion) VALUES (?)";
        try (PreparedStatement stmt = conexion.obtenerConexion().prepareStatement(sql)) {
            stmt.setString(1, tipoProducto.getDescripcion());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(TipoProducto tipoProducto) {
        String sql = "UPDATE hostal.tipo_producto SET descripcion = ? WHERE id_tipoproducto = ?";
        try (PreparedStatement stmt = conexion.obtenerConexion().prepareStatement(sql)) {
            stmt.setString(1, tipoProducto.getDescripcion());
            stmt.setInt(2, tipoProducto.getIdTipoProducto());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(TipoProducto tipoProducto) {
        String sql = "DELETE FROM hostal.tipo_producto WHERE id_tipoproducto = ?";
        try (PreparedStatement stmt = conexion.obtenerConexion().prepareStatement(sql)) {
            stmt.setInt(1, tipoProducto.getIdTipoProducto());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public TipoProducto select(TipoProducto tipoProducto) {
        TipoProducto result = null;
        String sql = "SELECT * FROM hostal.tipo_producto WHERE id_tipoproducto = ?";
        try (PreparedStatement stmt = conexion.obtenerConexion().prepareStatement(sql)) {
            stmt.setInt(1, tipoProducto.getIdTipoProducto());
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                result = new TipoProducto();
                result.setIdTipoProducto(rs.getInt("id_tipoproducto"));
                result.setDescripcion(rs.getString("descripcion"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public TipoProducto selectById(int id) {
        TipoProducto result = null;
        String sql = "SELECT * FROM hostal.tipo_producto WHERE id_tipoproducto = ?";
        try (PreparedStatement stmt = conexion.obtenerConexion().prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                result = new TipoProducto();
                result.setIdTipoProducto(rs.getInt("id_tipoproducto"));
                result.setDescripcion(rs.getString("descripcion"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<TipoProducto> selectAll() {
        List<TipoProducto> result = new ArrayList<>();
        String sql = "SELECT * FROM hostal.tipo_producto";
        try (PreparedStatement stmt = conexion.obtenerConexion().prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                TipoProducto tipoProducto = new TipoProducto();
                tipoProducto.setIdTipoProducto(rs.getInt("id_tipoproducto"));
                tipoProducto.setDescripcion(rs.getString("descripcion"));
                result.add(tipoProducto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<String> getAllDescriptions() {

        List<String> result = new ArrayList<>();
        String sql = "SELECT descripcion FROM hostal.tipo_producto";
        try (PreparedStatement stmt = conexion.obtenerConexion().prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                result.add(rs.getString("descripcion"));
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return result;
    }

    @Override
    public int getIdByDescription(String tipoProductoSeleccionado) {

        int result = 0;
        String sql = "SELECT id_tipoproducto FROM hostal.tipo_producto WHERE descripcion = ?";
        try (PreparedStatement stmt = conexion.obtenerConexion().prepareStatement(sql)) {
            stmt.setString(1, tipoProductoSeleccionado);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                result = rs.getInt("id_tipoproducto");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}