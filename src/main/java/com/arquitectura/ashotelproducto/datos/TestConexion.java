package com.arquitectura.ashotelproducto.datos;


import com.arquitectura.ashotelproducto.datos.conexion.ConexionMySQL;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestConexion extends JFrame{
    private JTable table;
    private DefaultTableModel tableModel;

    public TestConexion() {
        setTitle("Visualizador de Usuarios");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Crear tabla
        tableModel = new DefaultTableModel();
        table = new JTable(tableModel);

        // Agregar tabla a JScrollPane
        JScrollPane scrollPane = new JScrollPane(table);

        // Agregar JScrollPane al contenido del frame
        getContentPane().add(scrollPane, BorderLayout.CENTER);

        // Mostrar la ventana
        setVisible(true);

        // Llenar la tabla con datos de la base de datos
        try {
            ConexionMySQL ConexionMySQL = new ConexionMySQL();
            Connection connection = ConexionMySQL.obtenerConexion();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Usuario");

            // Obtener metadatos para establecer el nombre de las columnas
            int columnCount = resultSet.getMetaData().getColumnCount();
            for (int i = 1; i <= columnCount; i++) {
                tableModel.addColumn(resultSet.getMetaData().getColumnName(i));
            }

            // Agregar filas a la tabla
            while (resultSet.next()) {
                Object[] row = new Object[columnCount];
                for (int i = 0; i < columnCount; i++) {
                    row[i] = resultSet.getObject(i + 1);
                }
                tableModel.addRow(row);
            }

            // Cerrar
            resultSet.close();
            statement.close();
            ConexionMySQL.cerrarConexion(connection);
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al cargar datos de la base de datos: " + e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    public static void main(String[] args) throws SQLException {
        Connection connection = null;
        ConexionMySQL ConexionMySQL = new ConexionMySQL();

        try {
            // Obtener la conexión

            connection = ConexionMySQL.obtenerConexion();
            System.out.println("Conexión establecida correctamente.");
            JOptionPane.showMessageDialog(null, "Conexión establecida correctamente.", "Conexión", JOptionPane.INFORMATION_MESSAGE);

            SwingUtilities.invokeLater(TestConexion::new);


        } finally {
            // Cerrar la conexión
            ConexionMySQL.cerrarConexion(connection);
            JOptionPane.showMessageDialog(null, "Conexión cerrada correctamente.", "Conexión", JOptionPane.INFORMATION_MESSAGE);
            System.out.println("Conexión cerrada correctamente.");
        }
    }
}
