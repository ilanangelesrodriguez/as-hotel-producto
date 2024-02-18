package com.arquitectura.ashotelproducto.datos.reserva;


import com.arquitectura.ashotelproducto.datos.conexion.Conexion;
import com.arquitectura.ashotelproducto.datos.conexion.ConexionMySQL;
import com.arquitectura.ashotelproducto.dominio.reserva.TipoReserva;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TipoReservaDAOImpl implements TipoReservaDAO {
    private final Conexion conexion;

    public TipoReservaDAOImpl() throws SQLException {
        this.conexion = new ConexionMySQL();
    }

    @Override
    public void insert(TipoReserva tipoReserva) {
        String sql = "INSERT INTO tipo_reserva (descripcion) VALUES (?)";
        try (Connection conn = conexion.obtenerConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, tipoReserva.getDescripcion());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void update(TipoReserva tipoReserva) {
        String sql = "UPDATE tipo_reserva SET descripcion = ? WHERE id_tipo_reserva = ?";
        try (Connection conn = conexion.obtenerConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, tipoReserva.getDescripcion());
            pstmt.setInt(2, tipoReserva.getIdTipoReserva());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void delete(TipoReserva tipoReserva) {
        String sql = "DELETE FROM tipo_reserva WHERE id_tipo_reserva = ?";
        try (Connection conn = conexion.obtenerConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, tipoReserva.getIdTipoReserva());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public TipoReserva select(TipoReserva tipoReserva) {
        return null;
    }

    @Override
    public TipoReserva selectById(int id) {
        String sql = "SELECT * FROM tipo_reserva WHERE id_tipo_reserva = ?";
        try (Connection conn = conexion.obtenerConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new TipoReserva(rs.getInt("id_tipo_reserva"), rs.getString("descripcion"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public List<TipoReserva> selectAll() {
        List<TipoReserva> tipoReservas = new ArrayList<>();
        String sql = "SELECT * FROM tipo_reserva";
        try (Connection conn = conexion.obtenerConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                tipoReservas.add(new TipoReserva(rs.getInt("id_tipo_reserva"), rs.getString("descripcion")));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return tipoReservas;
    }

    @Override
    public TipoReserva selectByDescripcion(String tipoReservaDescripcion) {
        String sql = "SELECT * FROM tipo_reserva WHERE descripcion = ?";
        try (Connection conn = conexion.obtenerConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, tipoReservaDescripcion);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new TipoReserva(rs.getInt("id_tipo_reserva"), rs.getString("descripcion"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
