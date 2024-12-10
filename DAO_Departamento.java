package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAO_Departamento {

    public void add(DTO_Departamento departamento) throws SQLException {
        String query = "INSERT INTO departamento (ID, Nombre) VALUES (?, ?)";
        try (Connection conn = DB.getConexion();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, departamento.getIdDepartamento());
            stmt.setString(2, departamento.getNomeDepartamento());
            stmt.executeUpdate();
        }
    }

    public DTO_Departamento get(int idDepartamento) throws SQLException {
        String query = "SELECT * FROM departamento WHERE ID = ?";
        try (Connection conn = DB.getConexion();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, idDepartamento);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new DTO_Departamento(
                            rs.getInt("ID"),
                            rs.getString("Nombre")
                    );
                }
            }
        }
        return null;
    }

    public List<DTO_Departamento> getAll() throws SQLException {
        List<DTO_Departamento> departamentos = new ArrayList<>();
        String query = "SELECT * FROM departamento";
        try (Connection conn = DB.getConexion();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                departamentos.add(new DTO_Departamento(
                        rs.getInt("ID"),
                        rs.getString("Nombre")
                ));
            }
        }
        return departamentos;
    }

    public void update(DTO_Departamento departamento) throws SQLException {
        String query = "UPDATE departamento SET Nombre = ? WHERE ID = ?";
        try (Connection conn = DB.getConexion();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, departamento.getNomeDepartamento());
            stmt.setInt(2, departamento.getIdDepartamento());
            stmt.executeUpdate();
        }
    }

    public void delete(int idDepartamento) throws SQLException {
        String query = "DELETE FROM departamento WHERE ID = ?";
        try (Connection conn = DB.getConexion();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, idDepartamento);
            stmt.executeUpdate();
        }
    }

    public List<DTO_Departamento> orderBy(String field, boolean ascending) throws SQLException {
        List<DTO_Departamento> departamentos = new ArrayList<>();
        String query = "SELECT * FROM departamento ORDER BY " + field + (ascending ? " ASC" : " DESC");
        try (Connection conn = DB.getConexion();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                departamentos.add(new DTO_Departamento(
                        rs.getInt("ID"),
                        rs.getString("Nombre")
                ));
            }
        }
        return departamentos;
    }

}
