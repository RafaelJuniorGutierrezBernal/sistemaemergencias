package models;

import java.util.concurrent.TimeUnit;

public abstract class Emergencia {
    protected String tipo;
    protected String ubicacion;
    protected int nivelPrioridad;
    protected double tiempoRespuesta;
    protected String estado;

    // Constructor base para todas las emergencias
    public Emergencia(String tipo, String ubicacion, int nivelPrioridad, double tiempoRespuesta) {
        this.tipo = tipo;
        this.ubicacion = ubicacion;
        this.nivelPrioridad = nivelPrioridad;
        this.tiempoRespuesta = tiempoRespuesta;
        this.estado = "Pendiente"; // Estado inicial de la emergencia
    }

    public abstract void gestionarEmergencia();

    // Método abstracto para definir el recurso necesario según la emergencia
    public abstract String getTipoRecursoNecesario();

    // Simula el tiempo de respuesta para la emergencia
    protected void simularTiempo() {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    // Getters y representación en texto
    public String getTipo() { return tipo; }
    public String getUbicacion() { return ubicacion; }
    public int getNivelPrioridad() { return nivelPrioridad; }
    public double getTiempoRespuesta() { return tiempoRespuesta; }
    public String getEstado() { return estado; }

    @Override
    public String toString() {
        return "Emergencia [tipo=" + tipo + ", ubicacion=" + ubicacion + ", nivelPrioridad=" + nivelPrioridad
                + ", tiempoRespuesta=" + tiempoRespuesta + ", estado=" + estado + "]";
    }
}