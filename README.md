Sistema de Gestión de Emergencias Urbanas
📋 Descripción del Proyecto:
Este sistema de gestión de emergencias es una aplicación de consola desarrollada en Java que simula la coordinación de servicios de emergencia en una ciudad. El proyecto permite registrar, gestionar y atender diferentes tipos de emergencias (Incendio, Accidente Vehicular, Robo) de manera eficiente.

✨ Características Principales:
Registro de emergencias con diferentes niveles de gravedad
Asignación automática de recursos según el tipo de emergencia
Gestión dinámica de recursos de emergencia
Seguimiento y estadísticas de emergencias atendidas
Interfaz de usuario intuitiva en consola

🛠️ Tecnologías Utilizadas:
Java 17+
Patrón Singleton
Patrón Factory Method
Programación Orientada a Objetos
Manejo de excepciones

📦Estructura del Proyecto
La estructura de carpetas y archivos es la siguiente:
sistemaemergencias/
├── vscode

├── bin

├── lib

└── src

    ├── controllers
    
    │   ├── AmbulanciaRecurso.java
    
    │   ├── BomberosRecurso.java
    
    │   ├── EmergencyController.java
    
    │   ├── Estadisticas.java
    
    │   ├── PoliciaRecurso.java
    
    │   ├── Recurso.java
    
    │   └── ResourceManager.java
    
    ├── models
    
    │   ├── AccidenteVehicular.java
    
    │   ├── Emergencia.java
    
    │   ├── Incendio.java
    
    │   └── Robo.java
    
    ├── services
    
    │   ├── Ambulancia.java
    
    │   ├── Bomberos.java
    
    │   ├── Policia.java
    
    │   └── ServicioEmergencia.java
    
    └── utils
    
    |    └── EmergencyFactory.java
    
    |
    └── Main.java

La carpeta controllers contiene las clases que manejan la lógica del sistema, como el controlador principal, la gestión de recursos y las estadísticas.
La carpeta models define las clases que representan los diferentes tipos de emergencias.
La carpeta services incluye las clases que modelan los servicios de emergencia (Ambulancia, Bomberos, Policía).
La carpeta utils contiene la fábrica de emergencias.
El main java se encarga de ejecutar el programa como tal.

Instalación y Uso
Para instalar y ejecutar el sistema, sigue estos pasos:

Clona el repositorio en tu máquina local.
Abre el proyecto en tu IDE de Java preferido.
Compila y ejecuta la clase Main.java 

🤝Contribución
Si deseas contribuir al proyecto, puedes seguir estos pasos:

Haz un fork del repositorio.
Crea una nueva rama para tus cambios.
Realiza tus modificaciones y actualiza la documentación si es necesario.
Envía un pull request con tus cambios.

📞Contacto
Para más información o reportar problemas, puedes comunicarte con el equipo de desarrollo:

Nombre: [Rafael Junior Gutierrez Bernal]
Correo electrónico: [rafas8921@gmail.com]

🏆 Reconocimientos
Dev Senior.

