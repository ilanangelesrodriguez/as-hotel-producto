package com.arquitectura.ashotelproducto.dominio.login;


import com.arquitectura.ashotelproducto.datos.conexion.Conexion;
import com.arquitectura.ashotelproducto.datos.conexion.ConexionMySQL;
import com.arquitectura.ashotelproducto.dominio.Rol;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Clase que gestiona la autenticación de usuarios en el sistema.
 *
 * <p>La clase utiliza el patrón Singleton para garantizar una única instancia global de la clase.</p>
 *
 * <p>Proporciona métodos para autenticar usuarios, encontrar usuarios por nombre de usuario, y
 * mantener listas de usuarios y roles en el sistema.</p>
 *
 */
public class LoginUsuario {

    private static LoginUsuario instance;
    Connection connection = null;

    public LoginUsuario() throws SQLException {
        Conexion conexion = new ConexionMySQL();
        connection = conexion.obtenerConexion();
    }

    public static LoginUsuario getInstance() throws SQLException {
        if (instance == null) {
            instance = new LoginUsuario();
        }
        return instance;
    }

    public int autenticar(String username, String password) throws SQLException {
        Usuario usuario = encontrarUsuario(username);
        if (usuario != null) {
            if (usuario.getPassword().equals(password)) {
                System.out.println("Credenciales válidas para usuario: " + usuario.getName());
                return 0; // Autenticación exitosa
            } else {
                // Credenciales inválidas
                System.out.println("Intento de login fallido para usuario: " + username);
                return 2; // Contraseña incorrecta
            }
        } else {
            System.out.println("La cuenta no existe");
            return 1; // Usuario no encontrado
        }
    }

    /**
     * Encuentra un usuario por su nombre de usuario.
     *
     * @param username Nombre de usuario a buscar.
     * @return Usuario encontrado o null si no se encuentra.
     */
    public Usuario encontrarUsuario(String username) throws SQLException {
        String query = "SELECT * FROM Usuario INNER JOIN Rol ON Usuario.id_rol = Rol.id_rol WHERE Usuario.username = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, username);
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            Rol rol = new Rol(resultSet.getInt("id_rol"), resultSet.getString("nombre_rol"));
            Usuario usuario = new Usuario(resultSet.getString("username"), rol, resultSet.getString("password"));
            usuario.setName(resultSet.getString("name"));
            usuario.setLastName(resultSet.getString("lastName"));
            return usuario;
        }
        return null;
    }

}

