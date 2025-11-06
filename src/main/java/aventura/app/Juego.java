package aventura.app;

import java.util.Scanner;

/**
 * Clase principal del juego "Tu Propia Aventura".
 * Esqueleto para la Misión 1 (UD1-UD3).
 * VUESTRO TRABAJO es rellenar todos los TODO
 */
public class Juego {

    // --- NÚCLEO: Definición de Datos (FASE 1) ---
    // Esta parte os la damos HECHA. Es el "contrato" del núcleo.

    private static String descripcionJuego = "Estás en tu apartamento. Son las 10 de la mañana, pero todo está sumido en una oscuridad extraña, como si el sol nunca hubiera salido. " +
            "Sientes un frío en el aire, algo fuera de lugar. Te acercas a la ventana y miras afuera. La calle está vacía... pero hay figuras moviéndose lentamente, con movimientos torpes, sin rumbo ni sentido, como si no tuvieran conciencia. Sus ojos parecen vacíos, y un silencio inquietante cubre todo. " +
            "Un escalofrío recorre tu espalda, pero intentas convencerte de que es una especie de tormenta o un apagón. Te preparas para salir y asistir a tu clase de programación, pero algo dentro de ti dice que hoy no será un día normal.\n" +
            "Mientras apagas la luz y agarras tu mochila, percibes un leve susurro que parece venir de las paredes. No sabes si es tu imaginación o si algo más está allí, acechando.\n";


    // El mapa de habitaciones.
    // TODO: (Skin) ¡Rellenad esto con vuestras descripciones!
    private static String[] habitaciones = {
            "Estás en tu apartamento, el 100. Puedes salir por la puerta a la DERECHA.",  // Posición 0
            "Estás en el pasillo . Hay puertas a la DERECHA y a la IZQUIERDA. Los apartamentos 101 y 102. ", // Posición 1
            "Estás en el apartamento 101. Hay una 'llave' en una mesa, y escuchas un ruido extraño debajo de la mesa, miras y ves una antigua 'radio'.", // Posición 2
            // Borra las habitaciones y escribe las tuyas
    };

    // Los objetos que hay en cada habitación.
    // TODO: (Skin) Rellenad esto con vuestros objetos
    private static String[][] objetosMapa = {
            {"linterna", null},           // Objetos en Apartamento 100
            {"llave", "radio"},      // Objetos en Apartamento 101
            {null, null},           // Objetos en Apartamento 102
    };

    // El inventario del jugador. Tamaño fijo.
    private static String[] inventario = new String[5];

    // Variable que guarda la posición actual del jugador
    private static int habitacionActual = 0; // Empezamos en la primera habitación

    // --- FIN DE LA DEFINICIÓN DE DATOS ---


    public static void main(String[] args) {
        // Puedes utilizar la clase MiEntradaSalida, que viviría en el paquete io
        Scanner scanner = new Scanner(System.in);
        boolean jugando = true;

        System.out.println("¡Bienvenido a 'TU PROPIA AVENTURA'!");
        System.out.println("------------------------------------------");

        // TODO 1a: Muestra la descripción general del juego
        System.out.println("Hola Bienvenido a The Blackout, un juego realizado por Moises y Victor, espero que disfrutes");
        System.out.println(descripcionJuego);
        // TODO 1b: Muestra la descripción de la primera habitación
        // Pista: System.out.println(habitaciones[...]);
        System.out.println(habitaciones[0]);

        // TODO 2: Iniciar el bucle principal del juego (game loop)
        while (jugando) {

            // TODO 3: Leer el comando del usuario por teclado
            System.out.print("\n> ");
            String comando = scanner.nextLine();

            /*
            TODO 4: Crear un 'switch' o una estructura 'if-else if'
             para procesar el 'comando' del usuario.
             Debe gestionar como mínimo: "ayuda", "mirar", "inventario",
             "ir derecha", "ir izquierda", "coger [objeto]" y "salir".
             */


        }

        System.out.println("¡Gracias por jugar!");
        scanner.close();
    }

    /*
    (Opcional - Buenas Prácticas)
    Si el 'switch' se vuelve muy grande, podéis crear métodos privados
    para organizar el código, por ejemplo:
    private static void procesarComandoCoger(String comando) { ... }
    private static void mostrarInfoHabitacion() { ... }
    */
}