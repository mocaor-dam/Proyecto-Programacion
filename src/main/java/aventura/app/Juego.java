package aventura.app;

import java.sql.SQLOutput;
import java.util.Arrays;
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
            "Estás en el apartamento 101. Hay una 'llave' en una mesa, y escuchas un ruido extraño debajo de la mesa, miras y ves una antigua 'radio'.", // Posición 1
            "Estás en tu apartamento, el 100. Hay puertas a la DERECHA y a la IZQUIERDA. Los apartamentos 101 y 102.",  // Posición 0
            "Estás en el apartamento 102. Hay un cofre con una cerradura para una llave. \n escuchas que la radio empieza a hacer ruidos extraños... \n ¨MHASDAMDmasndb...¨ Es ilegible.." //Posición 2

    };

    // Los objetos que hay en cada habitación.
    private static String[][] objetosMapa = {
            {"llave", "radio"},      // Objetos en Apartamento 101
            {"linterna", null},        // Objetos en Apartamento 100
            {null, null},           // Objetos en Apartamento 102
    };

    // El inventario del jugador. Tamaño fijo.
    private static String[] inventario = new String[5];

    // Variable que guarda la posición actual del jugador
    private static int habitacionActual = 1; // Empezamos en la primera habitación


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
        System.out.println(habitaciones[habitacionActual]);

        // TODO 2: Iniciar el bucle principal del juego (game loop)
        while (jugando) {

            // TODO 3: Leer el comando del usuario por teclado
            System.out.print("\n> ");
            System.out.println("Introduce que quieres hacer:  ");
            String comando = scanner.nextLine().toLowerCase();
            switch (comando) {

                case "ayuda":
                    System.out.println("======================AYUDA======================");
                    System.out.println("Comandos disponibles: \n - ir derecha \n - ir izquierda \n - mirar \n - inventario \n - coger [objeto] \n - salir");
                    System.out.println("=================================================");
                    break;

                case "ir derecha":
                    irDerecha(); // Llama al metodo de movimiento implementado
                    break;
                case "ir izquierda":
                irIzquierda(); // Llama al metodo de moverse a la izquierda
                    break;

                case "mirar":
                    mirarHabitacion();
                    break;
                case "inventario":
                    //TODO: Aqui va el metodo de inventario
                    break;
                case "salir":
                    jugando = false;
                    break;

                default:
                    // Manejo de comandos complejos como 'coger llave'
                    if (comando.startsWith("coger ")) {
                        // TODO: Aquí va la lógica para coger objetos
                        String objeto = comando.substring(6); // Obtiene lo que está después de "coger "
                        System.out.println("Intentas coger: " + objeto + " (TODO: Implementar lógica)");
                    } else {
                        System.out.println("Comando no reconocido. Escribe 'ayuda' para ver las opciones.");
                    }
                    break;
            }



            /*
             4: Crear un 'switch' o una estructura 'if-else if'
             para procesar el 'comando' del usuario.
             Debe gestionar como mínimo: "ayuda", "mirar", "inventario",
             "ir derecha", "ir izquierda", "coger [objeto]" y "salir".
             */



        }

        System.out.println("¡Gracias por jugar!");
        scanner.close();
    }

    public static void irDerecha() {
        if (habitacionActual < habitaciones.length - 1) {
            //Aumentamos la posicion actual
            habitacionActual++;
            System.out.println("Te mueves a la derecha..");
            System.out.println(habitaciones[habitacionActual]);
        } else {
            System.out.println("No puedes ir mas a la derecha, hay una pared.");
        }
    }

    public static void mirarHabitacion() {
        System.out.println("\n" + habitaciones[habitacionActual]);

        //Mostrar los objetos
        System.out.println("Ves: ");
        boolean hayObjetos = false;
        for (String objeto : objetosMapa[habitacionActual]) {
            if (objeto != null) {
                System.out.println(objeto);
                hayObjetos = true;
            }
        }
        if (!hayObjetos) {
            System.out.println("No hay objetos en esta habitacion.");
        }
        System.out.println();
    }

    /*
    En este método irá a la habitación que esté a la izquierda no importe el lugar siempre que se introduzca el comando
     */
    public static void irIzquierda(){
        if (habitacionActual==1){
            habitacionActual--;
            System.out.println("Te mueves a la izquierda");
            System.out.println(habitaciones[habitacionActual]);
            return;
        }
       if (habitacionActual==2){
           habitacionActual--;
           System.out.println("Te mueves a la izquierda");
           System.out.println(habitaciones[habitacionActual]);
           return;
       }

        if (habitacionActual==0){
            habitacionActual=habitacionActual+2;
            System.out.println("Te mueves a la izquierda");
            System.out.println(habitaciones[habitacionActual]);
            return;
        }
    }

    /*
    (Opcional - Buenas Prácticas)
    Si el 'switch' se vuelve muy grande, podéis crear métodos privados
    para organizar el código, por ejemplo:
    private static void procesarComandoCoger(String comando) { ... }
    private static void mostrarInfoHabitacion() { ... }
    */

}