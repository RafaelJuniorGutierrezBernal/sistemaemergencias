package utils;

import java.util.Random;
import models.*;

public class EmergencyFactory {
    private static final Random random = new Random();

    // Método para crear una emergencia específica con tiempo de respuesta estandarizado
    public static Emergencia crearEmergencia(String tipo, String ubicacion, int prioridad) {
        double tiempoRespuesta = obtenerTiempoRespuesta(tipo, prioridad); // Obtener tiempo de respuesta según tipo y prioridad
        
        return switch (tipo) {
            case "Incendio" -> new Incendio(
                ubicacion, prioridad, tiempoRespuesta, "Pendiente",
                generarTipoFuego(), random.nextInt(5) + 1, random.nextBoolean()
            );
            case "Robo" -> new Robo(
                ubicacion, prioridad, tiempoRespuesta, "Pendiente",
                random.nextBoolean(), random.nextInt(5) + 1
            );
            case "AccidenteVehicular" -> new AccidenteVehicular(
                ubicacion, prioridad, tiempoRespuesta, "Pendiente",
                random.nextInt(10), random.nextBoolean()
            );
            default -> throw new IllegalArgumentException("Tipo de emergencia no reconocido.");
        };
    }

    // Método para obtener tiempo de respuesta estandarizado según el tipo y prioridad
    private static double obtenerTiempoRespuesta(String tipo, int prioridad) {
        // Definir tiempos de respuesta estándar para cada tipo de emergencia
        switch (tipo) {
            case "Incendio":
                return switch (prioridad) {
                    case 1 -> 6.0;  // 6 minutos para baja prioridad en incendio
                    case 2 -> 4.0;  // 4 minutos para media prioridad en incendio
                    case 3 -> 2.0 ;  // 2 minutos para alta prioridad en incendio
                    default -> 5.0;
                };
            case "Robo":
                return switch (prioridad) {
                    case 1 -> 5.0;  // 5 minutos para baja prioridad en robo
                    case 2 -> 3.5;  // 3.5 minutos para media prioridad en robo
                    case 3 -> 2.5;  // 2.5 minutos para alta prioridad en robo
                    default -> 4.0;
                };
            case "AccidenteVehicular":
                return switch (prioridad) {
                    case 1 -> 6.0;  // 6 minutos para baja prioridad en accidente vehicular
                    case 2 -> 4.5;  // 4.5 minutos para media prioridad en accidente vehicular
                    case 3 -> 3.0;  // 3 minutos para alta prioridad en accidente vehicular
                    default -> 5.0;
                };
            default:
                throw new IllegalArgumentException("Tipo de emergencia no reconocido.");
        }
    }

    // Método para generar un tipo de fuego aleatorio
    private static String generarTipoFuego() {
        String[] tiposFuego = {"A", "B", "C", "D", "K"};
        return tiposFuego[random.nextInt(tiposFuego.length)];
    }
}

