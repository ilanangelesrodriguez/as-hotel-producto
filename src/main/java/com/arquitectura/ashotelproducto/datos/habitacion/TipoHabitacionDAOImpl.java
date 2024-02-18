package com.arquitectura.ashotelproducto.datos.habitacion;


import com.arquitectura.ashotelproducto.datos.conexion.Conexion;
import com.arquitectura.ashotelproducto.datos.conexion.ConexionMySQL;
import com.arquitectura.ashotelproducto.dominio.habitacion.TipoHabitacion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TipoHabitacionDAOImpl implements TipoHabitacionDAO {
    private Conexion conexion;

    public TipoHabitacionDAOImpl() throws SQLException {
        this.conexion = new ConexionMySQL();
    }

    @Override
    public void insert(TipoHabitacion tipoHabitacion) {
        String sql = "INSERT INTO tipo_habitacion (id_tipohabitacion, descripcion) VALUES (?, ?)";

        try (Connection conn = conexion.obtenerConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, tipoHabitacion.getIdTipoHabitacion());
            pstmt.setString(2, tipoHabitacion.getDescripcion());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(TipoHabitacion tipoHabitacion) {
        String sql = "UPDATE tipo_habitacion SET descripcion = ? WHERE id_tipohabitacion = ?";

        try (Connection conn = conexion.obtenerConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, tipoHabitacion.getDescripcion());
            pstmt.setInt(2, tipoHabitacion.getIdTipoHabitacion());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(TipoHabitacion tipoHabitacion) {
        String sql = "DELETE FROM tipo_habitacion WHERE id_tipohabitacion = ?";

        try (Connection conn = conexion.obtenerConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, tipoHabitacion.getIdTipoHabitacion());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public TipoHabitacion select(TipoHabitacion tipoHabitacion) {
        return selectById(tipoHabitacion.getIdTipoHabitacion());
    }

    @Override
    public TipoHabitacion selectById(int id) {
        String sql = "SELECT * FROM tipo_habitacion WHERE id_tipohabitacion = ?";

        try (Connection conn = conexion.obtenerConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                return new TipoHabitacion(
                        rs.getInt("id_tipohabitacion"),
                        rs.getString("descripcion")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<TipoHabitacion> selectAll() {
        List<TipoHabitacion> tiposHabitacion = new ArrayList<>();
        String sql = "SELECT * FROM tipo_habitacion";

        try (Connection conn = conexion.obtenerConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                tiposHabitacion.add(new TipoHabitacion(
                        rs.getInt("id_tipohabitacion"),
                        rs.getString("descripcion")
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return tiposHabitacion;
    }
}