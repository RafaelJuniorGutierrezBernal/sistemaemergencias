package models;

public class Incendio extends Emergencia {
    private String tipoFuego;
    private int cantidadCamionesNecesarios;
    private boolean materialesPeligrosos;

    public Incendio(String ubicacion, int nivelPrioridad, double tiempoRespuesta, String estado,
                    String tipoFuego, int cantidadCamionesNecesarios, boolean materialesPeligrosos) {
        super("Incendio", ubicacion, nivelPrioridad, tiempoRespuesta);
        this.tipoFuego = tipoFuego;
        this.cantidadCamionesNecesarios = cantidadCamionesNecesarios;
        this.materialesPeligrosos = materialesPeligrosos;
    }

    @Override
    public String getTipoRecursoNecesario() {
        return "Bomberos"; // Recurso necesario para un incendio
    }

    @Override
    public void gestionarEmergencia() {
        System.out.println("Gestionando incendio tipo " + tipoFuego +
                " en " + getUbicacion() +
                ". Camiones necesarios: " + cantidadCamionesNecesarios +
                ". Materiales peligrosos: " + (materialesPeligrosos ? "Sí" : "No"));
    }
}