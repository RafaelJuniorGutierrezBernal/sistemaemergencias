package models;

import java.util.concurrent.TimeUnit;

public abstract class Emergencia {
    protected String tipo;
    protected String ubicacion;
    protected int nivelPrioridad;
    protected double tiempoRespuesta;
    protected String estado;
   

    public Emergencia(String tipo, String ubicacion, int nivelPrioridad, double tiempoRespuesta) {
        this.tipo = tipo;
        this.ubicacion = ubicacion;
        this.nivelPrioridad = nivelPrioridad;
        this.tiempoRespuesta = tiempoRespuesta;
        this.estado = "Pendiente";
    }

    public abstract void gestionarEmergencia();

    // Método abstracto para obtener el tipo de recurso necesario
    public abstract String getTipoRecursoNecesario();

    protected void simularTiempo() {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
    // Lista que almacena las emergencias registradas (debe ser una estructura global o de clase)





    // Getters y Setters
    public String getTipo() {
        return tipo;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public int getNivelPrioridad() {
        return nivelPrioridad;
    }

    public double getTiempoRespuesta() {
        return tiempoRespuesta;
    }

    public String getEstado() {
        return estado;
    }

    @Override
    public String toString() {
        return "Emergencia [tipo=" + tipo + ", ubicacion=" + ubicacion + ", nivelPrioridad=" + nivelPrioridad
                + ", tiempoRespuesta=" + tiempoRespuesta + ", estado=" + estado + "]";
    }
}