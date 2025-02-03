package services;

import models.Emergencia;

public class Policia implements ServicioEmergencia {
    @Override
    public void responderEmergencia(Emergencia emergencia) {
        System.out.println("🚓 Policias en camino a " + emergencia.getUbicacion());
        emergencia.gestionarEmergencia();
        System.out.println("Emergencia resuelta en " + emergencia.getTiempoRespuesta() + " minutos.");
    }
}

