package controllers;

import java.util.ArrayList;
import java.util.List;

import models.Emergencia;

public class ResourceManager {
    private static ResourceManager instance; // Instancia única
    private List<Recurso> recursos = new ArrayList<>();

    // Constructor privado para evitar instanciación externa
    private ResourceManager() {
        recursos.add(new AmbulanciaRecurso());
        recursos.add(new BomberosRecurso());
        recursos.add(new PoliciaRecurso());
    }

    // Método estático para obtener la instancia única
    public static ResourceManager getInstance() {
        if (instance == null) {
            instance = new ResourceManager();
        }
        return instance;
    }

    public Recurso asignarRecurso(Emergencia emergencia) {
        for (Recurso recurso : recursos) {
            if (recurso.isDisponible() && recurso.getTipo().equals(emergencia.getTipoRecursoNecesario())) {
                recurso.setDisponible(false);
                System.out.println("Recurso asignado: " + recurso.getTipo());
                return recurso;
            }
        }
        System.out.println("No hay recursos disponibles para: " + emergencia.getTipoRecursoNecesario());
        return null;
    }

    public void liberarRecurso(Recurso recurso) {
        if (recurso != null) {
            recurso.setDisponible(true);
            System.out.println(recurso.getTipo() + " está ahora disponible.");
        }
    }

    public void mostrarRecursos() {
        recursos.forEach(System.out::println);
    }
}