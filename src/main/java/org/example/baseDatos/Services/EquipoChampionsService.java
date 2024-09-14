package org.example.baseDatos.Services;

import org.example.baseDatos.Dao.EquipoChampionsDAO;
import org.example.baseDatos.Model.EquipoChampions;

import java.sql.SQLException;
import java.util.List;

public class EquipoChampionsService {
    private EquipoChampionsDAO dao;

    public EquipoChampionsService() {
        this.dao = new EquipoChampionsDAO();
    }

    public void addEquipo(EquipoChampions equipo) throws SQLException {
        dao.save(equipo);
    }

    public void updateEquipo(EquipoChampions equipo) throws SQLException {
        dao.update(equipo);
    }

    public void deleteEquipo(int idEquipo) throws SQLException {
        dao.delete(idEquipo);
    }

    public EquipoChampions getEquipoById(int idEquipo) throws SQLException {
        return dao.findById(idEquipo);
    }

    public List<EquipoChampions> getAllEquipos() throws SQLException {
        return dao.findAll();
    }
}

