package com.arquitectura.ashotelproducto.datos.estado;


import com.arquitectura.ashotelproducto.datos.conexion.Conexion;
import com.arquitectura.ashotelproducto.datos.conexion.ConexionMySQL;
import com.arquitectura.ashotelproducto.dominio.estado.Estado;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EstadoDAOImpl implements EstadoDAO {

    private Conexion conexion;

    public EstadoDAOImpl() throws SQLException {
        this.conexion = new ConexionMySQL();
    }

    @Override
    public void insert(Estado estado) {
        String sql = "INSERT INTO estado(id_estado, descripcion) VALUES (?, ?)";
        try (PreparedStatement ps = conexion.obtenerConexion().prepareStatement(sql)) {
            ps.setInt(1, estado.getId_estado());
            ps.setString(2, estado.getDescripcion());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Estado estado) {
        String sql = "UPDATE estado SET descripcion = ? WHERE id_estado = ?";
        try (PreparedStatement ps = conexion.obtenerConexion().prepareStatement(sql)) {
            ps.setString(1, estado.getDescripcion());
            ps.setInt(2, estado.getId_estado());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Estado estado) {
        String sql = "DELETE FROM estado WHERE id_estado = ?";
        try (PreparedStatement ps = conexion.obtenerConexion().prepareStatement(sql)) {
            ps.setInt(1, estado.getId_estado());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Estado select(Estado estado) {
        String sql = "SELECT * FROM estado WHERE id_estado = ?";
        try (PreparedStatement ps = conexion.obtenerConexion().prepareStatement(sql)) {
            ps.setInt(1, estado.getId_estado());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Estado(rs.getInt("id_estado"), rs.getString("descripcion"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Estado selectById(int id) {
        String sql = "SELECT * FROM estado WHERE id_estado = ?";
        try (PreparedStatement ps = conexion.obtenerConexion().prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Estado(rs.getInt("id_estado"), rs.getString("descripcion"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Estado> selectAll() {
        String sql = "SELECT * FROM estado";
        List<Estado> estados = new ArrayList<>();
        try (Statement stmt = conexion.obtenerConexion().createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                estados.add(new Estado(rs.getInt("id_estado"), rs.getString("descripcion")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return estados;
    }

    @Override
    public Estado selectByDescripcion(String estadoDescripcion) {
        String sql = "SELECT * FROM estado WHERE descripcion = ?";
        try (PreparedStatement ps = conexion.obtenerConexion().prepareStatement(sql)) {
            ps.setString(1, estadoDescripcion);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Estado(rs.getInt("id_estado"), rs.getString("descripcion"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
