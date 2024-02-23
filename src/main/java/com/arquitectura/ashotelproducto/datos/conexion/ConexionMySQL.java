package com.arquitectura.ashotelproducto.datos.conexion;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionMySQL implements Conexion {
    private static final String URL = "jdbc:mysql://localhost:3306/hostal?autoReconnect=true&useSSL=false";    private static final String USUARIO = "root";
    private static final String CONTRASENA = "sql2023";
    private final Connection conexion;

    public ConexionMySQL() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Establecer la conexión con la base de datos
            conexion = DriverManager.getConnection(URL, USUARIO, CONTRASENA);
        } catch (SQLException e) {
            System.err.println("Error al establecer la conexión con la base de datos: " + e.getMessage());
            throw e;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Connection obtenerConexion() {
        return conexion;
    }

    public void cerrarConexion(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexión");
            }
        }
    }



}

