package com.arquitectura.ashotelproducto.datos.reserva;


import com.arquitectura.ashotelproducto.datos.conexion.Conexion;
import com.arquitectura.ashotelproducto.datos.conexion.ConexionMySQL;
import com.arquitectura.ashotelproducto.dominio.reserva.Reserva;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReservaDAOImpl implements ReservaDAO {
    private Conexion conexion;

    public ReservaDAOImpl() throws SQLException {
        this.conexion = new ConexionMySQL();
    }

    @Override
    public void insert(Reserva reserva) {
        String sql = "INSERT INTO reserva (id_habitacion, id_cliente, id_turno, id_tipo_reserva, fecha_ingreso, cantidad_personas, fecha_fin, id_estado) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = conexion.obtenerConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, reserva.getIdHabitacion());
            pstmt.setInt(2, reserva.getIdCliente());
            pstmt.setInt(3, reserva.getIdTurno());
            pstmt.setString(4, reserva.getIdTipoReserva());
            pstmt.setTimestamp(5, new Timestamp(reserva.getFechaIngreso().getTime()));
            pstmt.setInt(6, reserva.getCantidadPersonas());
            pstmt.setTimestamp(7, new Timestamp(reserva.getFechaFin().getTime()));
            pstmt.setString(8, reserva.getEstado());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void update(Reserva reserva) {
        String sql = "UPDATE reserva SET id_habitacion = ?, id_cliente = ?, id_turno = ?, id_tipo_reserva = ?, fecha_ingreso = ?, cantidad_personas = ?, fecha_fin = ?, id_estado = ? WHERE id_reserva = ?";
        try (Connection conn = conexion.obtenerConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, reserva.getIdHabitacion());
            pstmt.setInt(2, reserva.getIdCliente());
            pstmt.setInt(3, reserva.getIdTurno());
            pstmt.setString(4, reserva.getIdTipoReserva());
            pstmt.setTimestamp(5, new Timestamp(reserva.getFechaIngreso().getTime()));
            pstmt.setInt(6, reserva.getCantidadPersonas());
            pstmt.setTimestamp(7, new Timestamp(reserva.getFechaFin().getTime()));
            pstmt.setString(8, reserva.getEstado());
            pstmt.setInt(9, reserva.getIdReserva());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void delete(Reserva reserva) {
        String sql = "DELETE FROM reserva WHERE id_reserva = ?";
        try (Connection conn = conexion.obtenerConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, reserva.getIdReserva());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Reserva select(Reserva reserva) {
        return null;
    }

    @Override
    public Reserva selectById(int id) {
        String sql = "SELECT * FROM reserva WHERE id_reserva = ?";
        try (Connection conn = conexion.obtenerConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new Reserva(
                        rs.getInt("id_reserva"),
                        rs.getInt("id_habitacion"),
                        rs.getInt("id_cliente"),
                        rs.getInt("id_turno"),
                        rs.getString("id_tipo_reserva"),
                        rs.getTimestamp("fecha_ingreso"),
                        rs.getInt("cantidad_personas"),
                        rs.getTimestamp("fecha_fin"),
                        rs.getString("id_estado")
                );
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }



    @Override
    public List<Reserva> selectAll() {
        List<Reserva> reservas = new ArrayList<>();
        String sql = "SELECT * FROM reserva";
        try (Connection conn = conexion.obtenerConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                reservas.add(new Reserva(rs.getInt("id_reserva"), rs.getInt("id_habitacion"), rs.getInt("id_cliente"), rs.getInt("id_turno"), rs.getString("id_tipo_reserva"), rs.getTimestamp("fecha_ingreso"), rs.getInt("cantidad_personas"), rs.getTimestamp("fecha_fin"), rs.getString("estado")));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return reservas;
    }

    public int getLastId() {
        String sql = "SELECT MAX(id_reserva) AS max_id FROM reserva";
        try (Connection conn = conexion.obtenerConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            if (rs.next()) {
                return rs.getInt("max_id") + 1;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return 1; // Devuelve 1 si no hay reservas en la base de datos
    }
}