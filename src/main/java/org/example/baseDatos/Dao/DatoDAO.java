package org.example.baseDatos.Dao;

import org.example.baseDatos.Conexion.DatabaseConnection;
import org.example.baseDatos.Model.Dato;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatoDAO {
    private Connection connection;

    public DatoDAO() {
        this.connection = DatabaseConnection.getConnection();
    }

    public void save(Dato dato) throws SQLException {
        String sql = "INSERT INTO tb_datos (nombre, apellido, departamento, fecha_nacimiento) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, dato.getNombre());
            stmt.setString(2, dato.getApellido());
            stmt.setString(3, dato.getDepartamento());
            stmt.setDate(4, dato.getFechaNacimiento());
            stmt.executeUpdate();
        }
    }

    public void update(Dato dato) throws SQLException {
        String sql = "UPDATE tb_datos SET nombre = ?, apellido = ?, departamento = ?, fecha_nacimiento = ? WHERE codigo = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, dato.getNombre());
            stmt.setString(2, dato.getApellido());
            stmt.setString(3, dato.getDepartamento());
            stmt.setDate(4, dato.getFechaNacimiento());
            stmt.setInt(5, dato.getCodigo());
            stmt.executeUpdate();
        }
    }

    public void delete(int codigo) throws SQLException {
        String sql = "DELETE FROM tb_datos WHERE codigo = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, codigo);
            stmt.executeUpdate();
        }
    }

    public Dato findById(int codigo) throws SQLException {
        String sql = "SELECT * FROM tb_datos WHERE codigo = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, codigo);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return mapResultSetToDato(rs);
                }
            }
        }
        return null;
    }

    public List<Dato> findAll() throws SQLException {
        List<Dato> datos = new ArrayList<>();
        String sql = "SELECT * FROM tb_datos";
        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                datos.add(mapResultSetToDato(rs));
            }
        }
        return datos;
    }

    private Dato mapResultSetToDato(ResultSet rs) throws SQLException {
        Dato dato = new Dato();
        dato.setCodigo(rs.getInt("codigo"));
        dato.setNombre(rs.getString("nombre"));
        dato.setApellido(rs.getString("apellido"));
        dato.setDepartamento(rs.getString("departamento"));
        dato.setFechaNacimiento(rs.getDate("fecha_nacimiento"));
        return dato;
    }
}

