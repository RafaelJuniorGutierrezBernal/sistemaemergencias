package controllers;

public class Estadisticas {
    private int emergenciasAtendidas;
    private int recursosUtilizados;

    public void registrarEmergenciaAtendida() {
        emergenciasAtendidas++;
        recursosUtilizados++;
    }

    public void mostrarEstadisticas() {
        System.out.println("Emergencias atendidas: " + emergenciasAtendidas);
        System.out.println("Recursos utilizados: " + recursosUtilizados);
    }

    public void mostrarResumenFinal() {
        System.out.println("--- Resumen Final ---");
        System.out.println("Total de emergencias atendidas: " + emergenciasAtendidas);
        System.out.println("Total de recursos utilizados: " + recursosUtilizados);
    }
}
