package com.arquitectura.ashotelproducto.datos.otros;


import com.arquitectura.ashotelproducto.datos.conexion.Conexion;
import com.arquitectura.ashotelproducto.datos.conexion.ConexionMySQL;
import com.arquitectura.ashotelproducto.dominio.TipoCambio;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TipoCambioDAOImpl implements TipoCambioDAO {
    private final Conexion conexion;

    public TipoCambioDAOImpl() throws SQLException {
        this.conexion = new ConexionMySQL();
    }

    @Override
    public void insert(TipoCambio tipoCambio) {
        String sql = "INSERT INTO tipo_cambio (moneda_origen, moneda_destino, valor_cambio, fecha_cambio) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = conexion.obtenerConexion().prepareStatement(sql)) {
            stmt.setString(1, tipoCambio.getMonedaOrigen());
            stmt.setString(2, tipoCambio.getMonedaDestino());
            stmt.setFloat(3, tipoCambio.getValorCambio());
            stmt.setDate(4, new Date(tipoCambio.getFechaCambio().getTime()));
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(TipoCambio tipoCambio) {
        String sql = "UPDATE tipo_cambio SET moneda_origen = ?, moneda_destino = ?, valor_cambio = ?, fecha_cambio = ? WHERE id_tipo_cambio = ?";
        try (PreparedStatement stmt = conexion.obtenerConexion().prepareStatement(sql)) {
            stmt.setString(1, tipoCambio.getMonedaOrigen());
            stmt.setString(2, tipoCambio.getMonedaDestino());
            stmt.setFloat(3, tipoCambio.getValorCambio());
            stmt.setDate(4, new Date(tipoCambio.getFechaCambio().getTime()));
            stmt.setInt(5, tipoCambio.getIdTipoCambio());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(TipoCambio tipoCambio) {
        String sql = "DELETE FROM tipo_cambio WHERE id_tipo_cambio = ?";
        try (PreparedStatement stmt = conexion.obtenerConexion().prepareStatement(sql)) {
            stmt.setInt(1, tipoCambio.getIdTipoCambio());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public TipoCambio select(TipoCambio tipoCambio) {
        TipoCambio result = null;
        String sql = "SELECT * FROM tipo_cambio WHERE id_tipo_cambio = ?";
        try (PreparedStatement stmt = conexion.obtenerConexion().prepareStatement(sql)) {
            stmt.setInt(1, tipoCambio.getIdTipoCambio());
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                result = new TipoCambio();
                result.setIdTipoCambio(rs.getInt("id_tipo_cambio"));
                result.setMonedaOrigen(rs.getString("moneda_origen"));
                result.setMonedaDestino(rs.getString("moneda_destino"));
                result.setValorCambio(rs.getFloat("valor_cambio"));
                result.setFechaCambio(rs.getDate("fecha_cambio"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public TipoCambio selectById(int id) {
        TipoCambio result = null;
        String sql = "SELECT * FROM tipo_cambio WHERE id_tipo_cambio = ?";
        try (PreparedStatement stmt = conexion.obtenerConexion().prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                result = new TipoCambio();
                result.setIdTipoCambio(rs.getInt("id_tipo_cambio"));
                result.setMonedaOrigen(rs.getString("moneda_origen"));
                result.setMonedaDestino(rs.getString("moneda_destino"));
                result.setValorCambio(rs.getFloat("valor_cambio"));
                result.setFechaCambio(rs.getDate("fecha_cambio"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<TipoCambio> selectAll() {
        List<TipoCambio> result = new ArrayList<>();
        String sql = "SELECT * FROM tipo_cambio";
        try (PreparedStatement stmt = conexion.obtenerConexion().prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                TipoCambio tipoCambio = new TipoCambio();
                tipoCambio.setIdTipoCambio(rs.getInt("id_tipo_cambio"));
                tipoCambio.setMonedaOrigen(rs.getString("moneda_origen"));
                tipoCambio.setMonedaDestino(rs.getString("moneda_destino"));
                tipoCambio.setValorCambio(rs.getFloat("valor_cambio"));
                tipoCambio.setFechaCambio(rs.getDate("fecha_cambio"));
                result.add(tipoCambio);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int getIdByMonedaDestino(String tipoCambioSeleccionado) {
        int result = 0;
        String sql = "SELECT id_tipo_cambio FROM tipo_cambio WHERE moneda_destino = ?";
        try (PreparedStatement stmt = conexion.obtenerConexion().prepareStatement(sql)) {
            stmt.setString(1, tipoCambioSeleccionado);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                result = rs.getInt("id_tipo_cambio");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
