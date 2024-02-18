package com.arquitectura.ashotelproducto.datos.habitacion;


import com.arquitectura.ashotelproducto.datos.conexion.Conexion;
import com.arquitectura.ashotelproducto.datos.conexion.ConexionMySQL;
import com.arquitectura.ashotelproducto.dominio.habitacion.Habitacion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HabitacionDAOImpl implements HabitacionDAO {
    private Conexion conexion;

    public HabitacionDAOImpl() throws SQLException {
        this.conexion = new ConexionMySQL();
    }

    @Override
    public void insert(Habitacion habitacion) {
        String sql = "INSERT INTO habitacion (id_habitacion, id_tipohabitacion, estado) VALUES (?, ?, ?)";

        try (Connection conn = conexion.obtenerConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, habitacion.getIdHabitacion());
            pstmt.setInt(2, habitacion.getIdTipoHabitacion());
            pstmt.setString(3, habitacion.getEstado());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Habitacion habitacion) {
        String sql = "UPDATE habitacion SET id_tipohabitacion = ?, estado = ? WHERE id_habitacion = ?";

        try (Connection conn = conexion.obtenerConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, habitacion.getIdTipoHabitacion());
            pstmt.setString(2, habitacion.getEstado());
            pstmt.setInt(3, habitacion.getIdHabitacion());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Habitacion habitacion) {
        String sql = "DELETE FROM habitacion WHERE id_habitacion = ?";

        try (Connection conn = conexion.obtenerConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, habitacion.getIdHabitacion());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Habitacion select(Habitacion habitacion) {
        return selectById(habitacion.getIdHabitacion());
    }

    @Override
    public Habitacion selectById(int id) {
        String sql = "SELECT * FROM habitacion WHERE id_habitacion = ?";

        try (Connection conn = conexion.obtenerConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                return new Habitacion(
                        rs.getInt("id_habitacion"),
                        rs.getInt("id_tipohabitacion"),
                        rs.getString("id_estado")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<Habitacion> selectAll() {
        List<Habitacion> habitaciones = new ArrayList<>();
        String sql = "SELECT * FROM habitacion";

        try (Connection conn = conexion.obtenerConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                habitaciones.add(new Habitacion(
                        rs.getInt("id_habitacion"),
                        rs.getInt("id_tipohabitacion"),
                        rs.getString("id_estado")
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return habitaciones;
    }


    @Override
    public Habitacion selectByDescripcion(String habitacionDescripcion) {
        String sql = "SELECT h.* FROM habitacion h " +
                "INNER JOIN tipo_habitacion th ON h.id_tipohabitacion = th.id_tipohabitacion " +
                "WHERE th.descripcion = ?";

        try (Connection conn = conexion.obtenerConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, habitacionDescripcion);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                return new Habitacion(
                        rs.getInt("id_habitacion"),
                        rs.getInt("id_tipohabitacion"),
                        rs.getString("id_estado")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}