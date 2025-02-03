package models;

public class AccidenteVehicular extends Emergencia {
    private int cantidadHeridos;
    private boolean bloqueoDeCarretera;

    public AccidenteVehicular(String ubicacion, int nivelPrioridad, double tiempoRespuesta, String estado,
                              int cantidadHeridos, boolean bloqueoDeCarretera) {
        super("AccidenteVehicular", ubicacion, nivelPrioridad, tiempoRespuesta);
        this.cantidadHeridos = cantidadHeridos;
        this.bloqueoDeCarretera = bloqueoDeCarretera;
    }

    @Override
    public String getTipoRecursoNecesario() {
        return "Ambulancia"; // Recurso necesario para un accidente vehicular
    }

    @Override
    public void gestionarEmergencia() {
        System.out.println("Gestionando accidente vehicular en " + getUbicacion() +
                ". Heridos: " + cantidadHeridos +
                ". Bloqueo de carretera: " + (bloqueoDeCarretera ? "Si" : "No"));
    }
}