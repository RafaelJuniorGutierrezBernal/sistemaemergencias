package utils;

import java.util.Map;
import java.util.Random;
import java.util.function.BiFunction;
import models.*;

public class EmergencyFactory {
    private static final Random random = new Random();

    // Mapeo de funciones para instanciar emergencias según el tipo
    private static final Map<String, BiFunction<String, Integer, Emergencia>> factoryMap = Map.of(
        "Incendio", (ubicacion, prioridad) -> new Incendio(
            ubicacion, prioridad, obtenerTiempoRespuesta("Incendio", prioridad), "Pendiente",
            generarTipoFuego(), random.nextInt(5) + 1, random.nextBoolean()
        ),
        "Robo", (ubicacion, prioridad) -> new Robo(
            ubicacion, prioridad, obtenerTiempoRespuesta("Robo", prioridad), "Pendiente",
            random.nextBoolean(), random.nextInt(5) + 1
        ),
        "AccidenteVehicular", (ubicacion, prioridad) -> new AccidenteVehicular(
            ubicacion, prioridad, obtenerTiempoRespuesta("AccidenteVehicular", prioridad), "Pendiente",
            random.nextInt(10), random.nextBoolean()
        )
    );

    // Método para crear una emergencia según el tipo
    public static Emergencia crearEmergencia(String tipo, String ubicacion, int prioridad) {
        if (!factoryMap.containsKey(tipo)) {
            throw new IllegalArgumentException("Tipo de emergencia no reconocido.");
        }
        return factoryMap.get(tipo).apply(ubicacion, prioridad);
    }

    // Método para calcular tiempos de respuesta según el tipo de emergencia y prioridad
    private static double obtenerTiempoRespuesta(String tipo, int prioridad) {
        return switch (tipo) {
            case "Incendio" -> switch (prioridad) {
                case 1 -> 6.0;
                case 2 -> 4.0;
                case 3 -> 2.0;
                default -> 5.0;
            };
            case "Robo" -> switch (prioridad) {
                case 1 -> 5.0;
                case 2 -> 3.5;
                case 3 -> 2.5;
                default -> 4.0;
            };
            case "AccidenteVehicular" -> switch (prioridad) {
                case 1 -> 6.0;
                case 2 -> 4.5;
                case 3 -> 3.0;
                default -> 5.0;
            };
            default -> throw new IllegalArgumentException("Tipo de emergencia no reconocido.");
        };
    }

    // Método para generar tipos de fuego aleatorios en incendios
    private static String generarTipoFuego() {
        String[] tiposFuego = {"A", "B", "C", "D", "K"};
        return tiposFuego[random.nextInt(tiposFuego.length)];
    }
}