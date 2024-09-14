package org.example.baseDatos.Dao;

import org.example.baseDatos.Conexion.DatabaseConnection;
import org.example.baseDatos.Model.EquipoChampions;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EquipoChampionsDAO {
    private Connection connection;

    public EquipoChampionsDAO() {
        this.connection = DatabaseConnection.getConnection();
    }

    public void save(EquipoChampions equipo) throws SQLException {
        String sql = "INSERT INTO equipos_champions (nombre, pais, ciudad, estadio, fundacion, entrenador, web_oficial, facebook, twitter, instagram, patrocinador_principal) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, equipo.getNombre());
            stmt.setString(2, equipo.getPais());
            stmt.setString(3, equipo.getCiudad());
            stmt.setString(4, equipo.getEstadio());
            stmt.setInt(5, equipo.getFundacion());
            stmt.setString(6, equipo.getEntrenador());
            stmt.setString(7, equipo.getWebOficial());
            stmt.setString(8, equipo.getFacebook());
            stmt.setString(9, equipo.getTwitter());
            stmt.setString(10, equipo.getInstagram());
            stmt.setString(11, equipo.getPatrocinadorPrincipal());
            stmt.executeUpdate();
        }
    }

    public void update(EquipoChampions equipo) throws SQLException {
        String sql = "UPDATE equipos_champions SET nombre = ?, pais = ?, ciudad = ?, estadio = ?, fundacion = ?, entrenador = ?, web_oficial = ?, facebook = ?, twitter = ?, instagram = ?, patrocinador_principal = ? WHERE id_equipo = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, equipo.getNombre());
            stmt.setString(2, equipo.getPais());
            stmt.setString(3, equipo.getCiudad());
            stmt.setString(4, equipo.getEstadio());
            stmt.setInt(5, equipo.getFundacion());
            stmt.setString(6, equipo.getEntrenador());
            stmt.setString(7, equipo.getWebOficial());
            stmt.setString(8, equipo.getFacebook());
            stmt.setString(9, equipo.getTwitter());
            stmt.setString(10, equipo.getInstagram());
            stmt.setString(11, equipo.getPatrocinadorPrincipal());
            stmt.setInt(12, equipo.getIdEquipo());
            stmt.executeUpdate();
        }
    }

    public void delete(int idEquipo) throws SQLException {
        String sql = "DELETE FROM equipos_champions WHERE id_equipo = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, idEquipo);
            stmt.executeUpdate();
        }
    }

    public EquipoChampions findById(int idEquipo) throws SQLException {
        String sql = "SELECT * FROM equipos_champions WHERE id_equipo = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, idEquipo);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return mapResultSetToEquipo(rs);
                }
            }
        }
        return null;
    }

    public List<EquipoChampions> findAll() throws SQLException {
        List<EquipoChampions> equipos = new ArrayList<>();
        String sql = "SELECT * FROM equipos_champions";
        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                equipos.add(mapResultSetToEquipo(rs));
            }
        }
        return equipos;
    }

    private EquipoChampions mapResultSetToEquipo(ResultSet rs) throws SQLException {
        EquipoChampions equipo = new EquipoChampions();
        equipo.setIdEquipo(rs.getInt("id_equipo"));
        equipo.setNombre(rs.getString("nombre"));
        equipo.setPais(rs.getString("pais"));
        equipo.setCiudad(rs.getString("ciudad"));
        equipo.setEstadio(rs.getString("estadio"));
        equipo.setFundacion(rs.getInt("fundacion"));
        equipo.setEntrenador(rs.getString("entrenador"));
        equipo.setWebOficial(rs.getString("web_oficial"));
        equipo.setFacebook(rs.getString("facebook"));
        equipo.setTwitter(rs.getString("twitter"));
        equipo.setInstagram(rs.getString("instagram"));
        equipo.setPatrocinadorPrincipal(rs.getString("patrocinador_principal"));
        equipo.setCreadoEn(rs.getTimestamp("creado_en"));
        return equipo;
    }
}
