
package controllers;

import java.util.ArrayList;
import java.util.List;
import models.Emergencia;

public class ResourceManager {
    private static ResourceManager instance; // Instancia única para el patrón Singleton
    private List<Recurso> recursos = new ArrayList<>(); // Lista de recursos disponibles

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

    // Asigna un recurso disponible según el tipo de emergencia
    public Recurso asignarRecurso(Emergencia emergencia) {
        for (Recurso recurso : recursos) {
            if (recurso.isDisponible() && recurso.getTipo().equals(emergencia.getTipoRecursoNecesario())) {
                recurso.setDisponible(false); // Marca el recurso como no disponible
                System.out.println("Recurso asignado: " + recurso.getTipo());
                return recurso;
            }
        }
        System.out.println("No hay recursos disponibles para: " + emergencia.getTipoRecursoNecesario());
        return null;
    }

    // Libera un recurso previamente utilizado
    public void liberarRecurso(Recurso recurso) {
        if (recurso != null) {
            recurso.setDisponible(true);
            System.out.println(recurso.getTipo() + " está ahora disponible.");
        }
    }

    // Muestra la lista de recursos disponibles
    public void mostrarRecursos() {
        recursos.forEach(System.out::println);
    }
}