import java.util.Scanner;

public class Main {

    static final int EOS = 0;
    public static void main(String[] args) {

        Equip equipLocal = new Equip();
        Equip equipVisitant = new Equip();

        Scanner entradaTeclat = new Scanner(System.in); // a java es fa aixi pels cin

        mostrarMenu(); // mostrem les opcions
        int opcio = entradaTeclat.nextInt(); // llegim de teclat

        while(opcio != EOS) {
            switch (opcio) {
                case 1:
                    enviarMissatge();
                    break;

                case 2:
                    amonestarJugador();
                    break;

                case 3:
                    canviarJugadors();
                    break;
            }

            mostrarMenu();
            opcio = entradaTeclat.nextInt();
        }

    }

    private static void mostrarMenu() {
        System.out.println("OPCIONS DEL PROGRAMA:");
        System.out.println("1. Enviar missatge als jugadors de la pista");
        System.out.println("2. Amonestar un jugador");
        System.out.println("3. Canviar jugadors");
    }

    // opcio 1, falta implementar i posar els arguments
    private static void enviarMissatge() {
        System.out.println("ENVIAR MISSATGE, per implementar");
    }

    // opcio 2, falta implementar i posar els arguments
    private static void amonestarJugador() {
        System.out.println("AMONESTAR, per implementar");
    }

    // opcio 3, falta implementar i posar els arguments
    private static void canviarJugadors() {
        System.out.println("CANVIAR JUGADORS, per implementar");
    }
}

