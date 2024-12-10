package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAO_Empleado {
    //add
    //get
    //getAll
    //update
    //delete
    //order ASC
    //order DESC

        public void add(DTO_Empleado empleado) throws SQLException {
            String query = "INSERT INTO empleado (nombreEmpleado, apellidoEmpleado, idDepartamento) VALUES (?, ?, ?)";
            try (Connection conn = DB.getConexion();
                 PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setString(1, empleado.getNombreEmpleado());
                stmt.setString(2, empleado.getApellidoEmpleado());
                stmt.setString(3, empleado.getIdDepartamento());
                stmt.executeUpdate();
            }
        }

        public DTO_Empleado get(int idEmpleado) throws SQLException {
            String query = "SELECT * FROM empleado WHERE idEmpleado = ?";
            try (Connection conn = DB.getConexion();
                 PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setInt(1, idEmpleado);
                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        return new DTO_Empleado(
                                rs.getString("nombreEmpleado"),
                                rs.getString("apellidoEmpleado"),
                                rs.getString("idDepartamento")
                        );
                    }
                }
            }
            return null;
        }

        public List<DTO_Empleado> getAll() throws SQLException {
            List<DTO_Empleado> empleados = new ArrayList<>();
            String query = "SELECT * FROM empleado";
            try (Connection conn = DB.getConexion();
                 Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery(query)) {
                while (rs.next()) {
                    empleados.add(new DTO_Empleado(
                            rs.getString("nombreEmpleado"),
                            rs.getString("apellidoEmpleado"),
                            rs.getString("idDepartamento")
                    ));
                }
            }
            return empleados;
        }

        public void update(DTO_Empleado empleado, int idEmpleado) throws SQLException {
            String query = "UPDATE empleado SET nombreEmpleado = ?, apellidoEmpleado = ?, idDepartamento = ? WHERE idEmpleado = ?";
            try (Connection conn = DB.getConexion();
                 PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setString(1, empleado.getNombreEmpleado());
                stmt.setString(2, empleado.getApellidoEmpleado());
                stmt.setString(3, empleado.getIdDepartamento());
                stmt.setInt(4, idEmpleado);
                stmt.executeUpdate();
            }
        }

        public void delete(int idEmpleado) throws SQLException {
            String query = "DELETE FROM empleado WHERE idEmpleado = ?";
            try (Connection conn = DB.getConexion();
                 PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setInt(1, idEmpleado);
                stmt.executeUpdate();
            }
        }

        public List<DTO_Empleado> orderBy(String field, boolean ascending) throws SQLException {
            List<DTO_Empleado> empleados = new ArrayList<>();
            String query = "SELECT * FROM empleado ORDER BY " + field + (ascending ? " ASC" : " DESC");
            try (Connection conn = DB.getConexion();
                 Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery(query)) {
                while (rs.next()) {
                    empleados.add(new DTO_Empleado(
                            rs.getString("nombreEmpleado"),
                            rs.getString("apellidoEmpleado"),
                            rs.getString("idDepartamento")
                    ));
                }
            }
            return empleados;
        }


}
