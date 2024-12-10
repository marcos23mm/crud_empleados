package org.example;

public class DTO_Departamento {

    private int idDepartamento;
    private String nomeDepartamento;

    public DTO_Departamento() {
        super();
    }

    public DTO_Departamento(int idDepartamento, String nomeDepartamento) {
        super();
        this.idDepartamento = idDepartamento;
        this.nomeDepartamento = nomeDepartamento;
    }

    public int getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(int idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public String getNomeDepartamento() {
        return nomeDepartamento;
    }

    public void setNomeDepartamento(String nomeDepartamento) {
        this.nomeDepartamento = nomeDepartamento;
    }

    @Override
    public String toString() {
        return "DTO_Departamento{" +
                "idDepartamento=" + idDepartamento +
                ", nomeDepartamento='" + nomeDepartamento + '\'' +
                '}';
    }

}
