package controllers;

public abstract class Recurso {
    private String tipo;
    private boolean disponible;

    public Recurso(String tipo) {
        this.tipo = tipo;
        this.disponible = true;
    }

    public String getTipo() {
        return tipo;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    @Override
    public String toString() {
        return tipo + ": " + (disponible ? "Disponible" : "No disponible");
    }
}