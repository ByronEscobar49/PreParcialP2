package org.example.baseDatos.Services;

import org.example.baseDatos.Dao.UsuarioDao;
import org.example.baseDatos.Model.Usuario;

import java.sql.SQLException;
import java.util.List;

public class usuarioservices {
    private UsuarioDao dao;

    public usuarioservices() {
        this.dao = new UsuarioDao();
    }

    public void addUsuario(Usuario usuario) throws SQLException {
        dao.save(usuario);
    }

    public void updateUsuario(Usuario usuario) throws SQLException {
        dao.update(usuario);
    }

    public void deleteUsuario(int idusuario) throws SQLException {
        dao.delete(idusuario);
    }

    public Usuario getUsuarioById(int idusuario) throws SQLException {
        return dao.findById(idusuario);
    }

    public List<Usuario> getAllUsuarios() throws SQLException {
        return dao.findAll();
    }
}

