package controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import models.AccidenteVehicular;
import models.Emergencia;
import models.Incendio;
import models.Robo;
import utils.EmergencyFactory;

public abstract class EmergencyController {
    private Scanner scanner = new Scanner(System.in);
    private ResourceManager resourceManager = ResourceManager.getInstance();
    private Estadisticas estadisticas = new Estadisticas();
    private List<Emergencia> emergenciasPendientes = new ArrayList<>();  // Lista de emergencias pendientes

    // Constantes para mensajes de error
    private static final String ERROR_NUMERO_INVALIDO = "Error: Debe ingresar un número. Por favor, intente nuevamente.";
    private static final String ERROR_FUERA_DE_RANGO = "Error: El valor debe estar entre %d y %d. Por favor, ingrese un número dentro de este rango.";
    private static final String ERROR_TIPO_EMERGENCIA = "Error: El tipo de emergencia debe ser 'Incendio', 'AccidenteVehicular' o 'Robo'. Por favor, ingrese uno de estos valores.";

    public void iniciarSistema() {
        while (true) {
            try {
                System.out.println("\n--- Menú Principal ---");
                System.out.println("1. Registrar Emergencia");
                System.out.println("2. Ver Estado de Recursos");
                System.out.println("3. Atender Emergencia");
                System.out.println("4. Mostrar Estadísticas");
                System.out.println("5. Finalizar Jornada");
                System.out.print("Seleccione una opción válida: ");
                int opcion = leerEntero(1, 5); // Validar que la opción esté entre 1 y 5
                scanner.nextLine(); // Limpiar el buffer

                switch (opcion) {
                    case 1 -> registrarEmergencia();
                    case 2 -> verEstadoRecursos();
                    case 3 -> atenderEmergencia();
                    case 4 -> mostrarEstadisticas();
                    case 5 -> {
                        finalizarJornada();
                        return;
                    }
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Ingrese un numero valido 1-5: " + e.getMessage());
            }
        }
    }

    private void registrarEmergencia() {
        try {
            // Obtención de datos del usuario
            System.out.print("Tipo de emergencia (Incendio, AccidenteVehicular, Robo): ");
            String tipo = leerTipoEmergencia(); // Validar el tipo de emergencia
    
            System.out.print("Ubicación: ");
            String ubicacion = scanner.nextLine();
    
            System.out.print("Gravedad (1: Baja, 2: Media, 3: Alta): ");
            int gravedad = leerEntero(1, 3); // Validar la gravedad
    
            // Crear la emergencia
            Emergencia emergencia = EmergencyFactory.crearEmergencia(tipo, ubicacion, gravedad);
            System.out.println("Emergencia registrada: " + emergencia);
    
            // Asignar recursos automáticamente
            Recurso recursoAsignado = resourceManager.asignarRecurso(emergencia);
            if (recursoAsignado != null) {
                estadisticas.registrarEmergenciaAtendida();
                System.out.println("Recurso asignado: " + recursoAsignado.getTipo());
            } else {
                System.out.println("No hay recursos disponibles para atender la emergencia.");
            }
    
            // Agregar la emergencia a la lista de emergencias pendientes
            emergenciasPendientes.add(emergencia);  // Se agrega a la lista de emergencias pendientes
        } catch (Exception e) {
            System.out.println("Error al registrar emergencia: " + e.getMessage());
        }
    }

    private void verEstadoRecursos() {
        System.out.println("\n--- Estado de Recursos ---");
        resourceManager.mostrarRecursos();
    }

    private void atenderEmergencia() {
        System.out.println("\n--- Atender Emergencia ---");
    
        // Obtener una emergencia pendiente
        Emergencia emergenciaPendiente = obtenerEmergenciaPendiente(); 
    
        if (emergenciaPendiente != null) {
            System.out.println("Emergencia a atender: " + emergenciaPendiente);
    
            // Verificar el tipo de emergencia y asignar recursos
            if (emergenciaPendiente instanceof Incendio) {
                Incendio incendio = (Incendio) emergenciaPendiente;
                // Lógica para atender un incendio
                System.out.println("Atendiendo incendio...");
                Recurso recursoAsignado = resourceManager.asignarRecurso(incendio);
                if (recursoAsignado != null) {
                    estadisticas.registrarEmergenciaAtendida();
                    System.out.println("Recurso asignado: " + recursoAsignado.getTipo());
                } else {
                    System.out.println("No hay recursos disponibles para atender el incendio.");
                }
            } else if (emergenciaPendiente instanceof Robo) {
                Robo robo = (Robo) emergenciaPendiente;
                // Lógica para atender un robo
                System.out.println("Atendiendo robo...");
                Recurso recursoAsignado = resourceManager.asignarRecurso(robo);
                if (recursoAsignado != null) {
                    estadisticas.registrarEmergenciaAtendida();
                    System.out.println("Recurso asignado: " + recursoAsignado.getTipo());
                } else {
                    System.out.println("No hay recursos disponibles para atender el robo.");
                }
            } else if (emergenciaPendiente instanceof AccidenteVehicular) {
                AccidenteVehicular accidente = (AccidenteVehicular) emergenciaPendiente;
                // Lógica para atender un accidente vehicular
                System.out.println("Atendiendo accidente vehicular...");
                Recurso recursoAsignado = resourceManager.asignarRecurso(accidente);
                if (recursoAsignado != null) {
                    estadisticas.registrarEmergenciaAtendida();
                    System.out.println("Recurso asignado: " + recursoAsignado.getTipo());
                } else {
                    System.out.println("No hay recursos disponibles para atender el accidente vehicular.");
                }
            } else {
                System.out.println("Tipo de emergencia no reconocido.");
            }
        } else {
            System.out.println("No hay emergencias pendientes para atender.");
        }
    }

    private Emergencia obtenerEmergenciaPendiente() {
        if (!emergenciasPendientes.isEmpty()) {
            return emergenciasPendientes.remove(0); // Retorna y elimina la primera emergencia de la lista
        }
        return null; // Si no hay emergencias pendientes
    }

    private void mostrarEstadisticas() {
        System.out.println("\n--- Estadísticas ---");
        estadisticas.mostrarEstadisticas();
    }

    private void finalizarJornada() {
        System.out.println("\n--- Finalizando Jornada ---");
        estadisticas.mostrarResumenFinal();
        resourceManager.mostrarRecursos();
    }

    // Método para leer un entero dentro de un rango específico
    public int leerEntero(int min, int max) {
        int opcion;
        while (true) {
            try {
                opcion = Integer.parseInt(scanner.nextLine()); // Leer la opción
                if (opcion < min || opcion > max) {
                    // Usar ERROR_FUERA_DE_RANGO
                    throw new IllegalArgumentException(String.format(ERROR_FUERA_DE_RANGO, min, max));
                }
                return opcion;
            } catch (NumberFormatException e) {
                // Usar ERROR_NUMERO_INVALIDO
                System.out.println(ERROR_NUMERO_INVALIDO);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    


    // Método para validar el tipo de emergencia
    private String leerTipoEmergencia() {
        while (true) {
            String tipo = scanner.nextLine().trim();
            // Convertir a minúsculas para evitar problemas con mayúsculas/minúsculas
            tipo = tipo.toLowerCase();

            // Verificar si el tipo es válido
            if (tipo.equals("incendio") || tipo.equals("accidentevehicular") || tipo.equals("robo")) {
                // Devolver el tipo con la primera letra en mayúscula
                return tipo.substring(0, 1).toUpperCase() + tipo.substring(1);
            } else {
                System.out.println(ERROR_TIPO_EMERGENCIA);
            }
        }
    }
}

            