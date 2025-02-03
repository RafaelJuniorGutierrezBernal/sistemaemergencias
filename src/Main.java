import controllers.EmergencyController;

public class Main {
    public static void main(String[] args) {
        // Crear una instancia del controlador de emergencias
        EmergencyController emergencyController = new EmergencyController() {};

        // Iniciar el sistema de gestión de emergencias
        emergencyController.iniciarSistema();
    }
}