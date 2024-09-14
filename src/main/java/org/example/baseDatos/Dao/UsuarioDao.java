package org.example.baseDatos.Dao;

import org.example.baseDatos.Conexion.DatabaseConnection;
import org.example.baseDatos.Model.Usuario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDao {
    private Connection connection;

    public UsuarioDao() {
        this.connection = DatabaseConnection.getConnection();
    }

    public void save(Usuario usuario) throws SQLException {
        String sql = "INSERT INTO tb_usuarios (carne, nombre, correo, seccion, telegramid, activo) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, usuario.getCarne());
            stmt.setString(2, usuario.getNombre());
            stmt.setString(3, usuario.getCorreo());
            stmt.setString(4, usuario.getSeccion());
            stmt.setLong(5, usuario.getTelegramid());
            stmt.setString(6, usuario.getActivo());
            stmt.executeUpdate();
        }
    }

    public void update(Usuario usuario) throws SQLException {
        String sql = "UPDATE tb_usuarios SET carne = ?, nombre = ?, correo = ?, seccion = ?, telegramid = ?, activo = ? WHERE idusuario = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, usuario.getCarne());
            stmt.setString(2, usuario.getNombre());
            stmt.setString(3, usuario.getCorreo());
            stmt.setString(4, usuario.getSeccion());
            stmt.setLong(5, usuario.getTelegramid());
            stmt.setString(6, usuario.getActivo());
            stmt.setInt(7, usuario.getIdusuario());
            stmt.executeUpdate();
        }
    }

    public void delete(int idusuario) throws SQLException {
        String sql = "DELETE FROM tb_usuarios WHERE idusuario = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, idusuario);
            stmt.executeUpdate();
        }
    }

    public Usuario findById(int idusuario) throws SQLException {
        String sql = "SELECT * FROM tb_usuarios WHERE idusuario = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, idusuario);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return mapResultSetToUsuario(rs);
                }
            }
        }
        return null;
    }

    public List<Usuario> findAll() throws SQLException {
        List<Usuario> usuarios = new ArrayList<>();
        String sql = "SELECT * FROM tb_usuarios";
        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                usuarios.add(mapResultSetToUsuario(rs));
            }
        }
        return usuarios;
    }

    private Usuario mapResultSetToUsuario(ResultSet rs) throws SQLException {
        Usuario usuario = new Usuario();
        usuario.setIdusuario(rs.getInt("idusuario"));
        usuario.setCarne(rs.getString("carne"));
        usuario.setNombre(rs.getString("nombre"));
        usuario.setCorreo(rs.getString("correo"));
        usuario.setSeccion(rs.getString("seccion"));
        usuario.setTelegramid(rs.getLong("telegramid"));
        usuario.setActivo(rs.getString("activo"));
        return usuario;
    }
}

