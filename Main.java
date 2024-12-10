package org.example;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        DAO_Departamento daoDepartamento = new DAO_Departamento();
        DAO_Empleado daoEmpleado = new DAO_Empleado();

        try {
            // Prueba: Añadir un departamento
            DTO_Departamento newDepartamento = new DTO_Departamento(10, "Informatica");
            daoDepartamento.add(newDepartamento);
            System.out.println("Departamento añadido: " + newDepartamento);
            

        } catch (SQLException e) {
            System.err.println("Error en la operación: " + e.getMessage());
        }
    }
}
