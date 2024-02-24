package com.arquitectura.ashotelproducto.datos.cliente;


import com.arquitectura.ashotelproducto.datos.conexion.Conexion;
import com.arquitectura.ashotelproducto.datos.conexion.ConexionMySQL;
import com.arquitectura.ashotelproducto.dominio.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAOImpl implements ClienteDAO {
    private Conexion conexion;

    public ClienteDAOImpl() throws SQLException {
        this.conexion = new ConexionMySQL();
    }

    @Override
    public void insert(Cliente cliente) {
        String sql = "INSERT INTO cliente (dni) VALUES (?)";
        try (Connection conn = conexion.obtenerConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, cliente.getDni());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public Cliente selectByDni(String dni) {
        String sql = "SELECT * FROM cliente WHERE dni = ?";
        try (Connection conn = conexion.obtenerConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, dni);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new Cliente(rs.getInt("id_cliente"), rs.getString("dni"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public void update(Cliente cliente) {
        // Implementar el método update
    }

    @Override
    public void delete(Cliente cliente) {
        // Implementar el método delete
    }

    @Override
    public Cliente select(Cliente cliente) {
        // Implementar el método select
        return null;
    }

    @Override
    public Cliente selectById(int id) {
        // Implementar el método selectById
        return null;
    }

    @Override
    public List<Cliente> selectAll() {
        List<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT * FROM cliente";
        try (Connection conn = conexion.obtenerConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                clientes.add(new Cliente(rs.getInt("id_cliente"), rs.getString("dni")));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return clientes;
    }

    @Override
    public Cliente buscarPorDni(String dni) {
        String sql = "SELECT * FROM cliente WHERE dni = ?";
        try (Connection conn = conexion.obtenerConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, dni);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new Cliente(rs.getInt("id_cliente"), rs.getString("dni"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
