package models;

public class Robo extends Emergencia {
    private boolean armasInvolucradas;
    private int cantidadSospechosos;

    public Robo(String ubicacion, int nivelPrioridad, double tiempoRespuesta, String estado,
                boolean armasInvolucradas, int cantidadSospechosos) {
        super("Robo", ubicacion, nivelPrioridad, tiempoRespuesta);
        this.armasInvolucradas = armasInvolucradas;
        this.cantidadSospechosos = cantidadSospechosos;
    }

    @Override
    public String getTipoRecursoNecesario() {
        return "Policia"; // Recurso necesario para un robo
    }

    @Override
    public void gestionarEmergencia() {
        System.out.println("Gestionando robo en " + getUbicacion() +
                ". Armas involucradas: " + (armasInvolucradas ? "Si" : "No") +
                ". Sospechosos: " + cantidadSospechosos);
    }
}