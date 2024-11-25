
/* RETO 1 - Simulador de Viaje Interplanetario
 * El desafío consistirá en desarrollar un programa que simule la planificación y ejecución de
un viaje interplanetario, donde el usuario podrá elegir destinos, calcular la distancia y el
tiempo de viaje, y gestionar los recursos de la nave. El objetivo es aplicar conceptos
básicos de programación de forma práctica y entretenida.
*/


import java.util.Scanner;
import java.util.Random;

public class SimuladorViaje {

    // Datos estaticos de los planetas
    static String[] planetas = {"Marte", "Júpiter", "Saturno"};
    static double[] distancias = {78, 628, 1275}; // Distancias en millones de km
    static String[] descripciones = {
        "El planeta rojo, conocido por su superficie de óxido de hierro.",
        "El gigante gaseoso con una gran mancha roja.",
        "El planeta de los anillos y uno de los más bellos del sistema solar."
    };

    // Datos estaticos de las naves espaciales
    static String[] naves = {"Columbia", "Estelar", "Discovery"};
    static double[] velocidades = {20, 50, 100}; // Velocidad en millones de km/día
    static int[] capacidades = {5, 10, 15}; // Número máximo de pasajeros

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Variables para selección del usuario
        int planetaSeleccionado = -1;
        int naveSeleccionada = -1;

        // Menú principal
        while (true) {
            System.out.println("==========================================");
            System.out.println("=== Simulador de Viaje Interplanetario ===");
            System.out.println("==========================================\n");
            System.out.println("1. Seleccionar Planeta de Destino");
            System.out.println("2. Seleccionar Nave Espacial");
            System.out.println("3. Iniciar Simulación del Viaje");
            System.out.println("4. Salir");
            System.out.print("Elige una opción: ");
            int opcion = scanner.nextInt();

      

            switch (opcion) {
                case 1 -> planetaSeleccionado = seleccionarPlaneta(scanner);
                case 2 -> naveSeleccionada = seleccionarNave(scanner);
                case 3 -> {
                    if (planetaSeleccionado >= 0 && naveSeleccionada >= 0) {
                        iniciarViaje(planetaSeleccionado, naveSeleccionada);
                    } else {
                        System.out.println("Primero selecciona un planeta y una nave.");
                    }
                }
                case 4 -> {
                    System.out.println("¡Gracias por usar el simulador! Hasta luego.");
                    return;
                }
                default -> System.out.println("Opción inválida. Intenta nuevamente.");
            }
        }
    }

    
    // Método para seleccionar planeta

        public static int seleccionarPlaneta(Scanner scanner) {
            System.out.println("\n=== Planetas Disponibles ===");
            for (int i = 0; i < planetas.length; i++) {
                System.out.printf("%d. %s (%,.0f millones de km)\n", i + 1, planetas[i], distancias[i]);
            }
            System.out.print("Selecciona un planeta (1-" + planetas.length + "): ");
            int seleccion = scanner.nextInt() - 1;
    
            if (seleccion >= 0 && seleccion < planetas.length) {
                System.out.printf("\n Has seleccionado: %s \n", planetas[seleccion]);
                System.out.println("Descripción: " + descripciones[seleccion]);
                return seleccion;
            } else {
                System.out.println("Selección inválida.");
                return -1;
            }
        }
   
}
