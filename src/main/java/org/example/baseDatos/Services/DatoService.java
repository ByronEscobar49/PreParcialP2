package org.example.baseDatos.Services;

import org.example.baseDatos.Dao.DatoDAO;
import org.example.baseDatos.Model.Dato;

import java.sql.SQLException;
import java.util.List;

public class DatoService {
    private DatoDAO dao;

    public DatoService() {
        this.dao = new DatoDAO();
    }

    public void addDato(Dato dato) throws SQLException {
        dao.save(dato);
    }

    public void updateDato(Dato dato) throws SQLException {
        dao.update(dato);
    }

    public void deleteDato(int codigo) throws SQLException {
        dao.delete(codigo);
    }

    public Dato getDatoById(int codigo) throws SQLException {
        return dao.findById(codigo);
    }

    public List<Dato> getAllDatos() throws SQLException {
        return dao.findAll();
    }
}

