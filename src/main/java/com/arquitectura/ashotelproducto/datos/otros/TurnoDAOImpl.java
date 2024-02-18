package com.arquitectura.ashotelproducto.datos.otros;


import com.arquitectura.ashotelproducto.datos.conexion.Conexion;
import com.arquitectura.ashotelproducto.datos.conexion.ConexionMySQL;
import com.arquitectura.ashotelproducto.dominio.turno.Turno;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TurnoDAOImpl implements TurnoDAO {
    private final Conexion conexion;

    public TurnoDAOImpl() throws SQLException {
        this.conexion = new ConexionMySQL();
    }

    @Override
    public void insert(Turno turno) {
        String sql = "INSERT INTO turno (nombre_turno, hora_inicio, hora_fin) VALUES (?, ?, ?)";
        try (Connection conn = conexion.obtenerConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, turno.getNombreTurno());
            pstmt.setTime(2, turno.getHoraInicio());
            pstmt.setTime(3, turno.getHoraFin());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void update(Turno turno) {
        String sql = "UPDATE turno SET nombre_turno = ?, hora_inicio = ?, hora_fin = ? WHERE id_turno = ?";
        try (Connection conn = conexion.obtenerConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, turno.getNombreTurno());
            pstmt.setTime(2, turno.getHoraInicio());
            pstmt.setTime(3, turno.getHoraFin());
            pstmt.setInt(4, turno.getIdTurno());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void delete(Turno turno) {
        String sql = "DELETE FROM turno WHERE id_turno = ?";
        try (Connection conn = conexion.obtenerConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, turno.getIdTurno());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Turno select(Turno turno) {
        return null;
    }

    @Override
    public Turno selectById(int id) {
        String sql = "SELECT * FROM turno WHERE id_turno = ?";
        try (Connection conn = conexion.obtenerConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new Turno(rs.getInt("id_turno"), rs.getString("nombre_turno"), rs.getTime("hora_inicio"), rs.getTime("hora_fin"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public List<Turno> selectAll() {
        List<Turno> turnos = new ArrayList<>();
        String sql = "SELECT * FROM turno";
        try (Connection conn = conexion.obtenerConexion();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                turnos.add(new Turno(rs.getInt("id_turno"), rs.getString("nombre_turno"), rs.getTime("hora_inicio"), rs.getTime("hora_fin")));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return turnos;
    }

    @Override
    public Turno selectByNombre(String turnoNombre) {
        String sql = "SELECT * FROM turno WHERE nombre_turno = ?";
        try (Connection conn = conexion.obtenerConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, turnoNombre);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new Turno(rs.getInt("id_turno"), rs.getString("nombre_turno"), rs.getTime("hora_inicio"), rs.getTime("hora_fin"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
