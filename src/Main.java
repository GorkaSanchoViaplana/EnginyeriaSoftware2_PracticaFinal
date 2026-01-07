import java.util.Scanner;

public class Main {

    static final int EOS = 0; //End of support?? 😭💀
    public static void main(String[] args) {
        Partit partit = new Partit(); //Basicament un placeholder no fa res i no crec que el fem servir
        Entrenador EntrenadorGirona = new Entrenador( "Miguel Angel","Sanchez Muñoz","321312312AA");
        Equip Girona = new Equip("Girona","Girona",EntrenadorGirona);
        Entrenador EntrenadorBarcelona = new Entrenador("Hansi","Flick","123123123BB");
        Equip Barcelona = new Equip("Barcelona","Barcelona",EntrenadorBarcelona);

        Posicio posicio=new Posicio(1,1,1);
        for(int i = 0; i<12; i++){

            Jugador j=new Jugador(""+i,"nom"+i,"cognom"+i,posicio);
            Jugador j2=new Jugador(""+12+i,"nom"+12+i,"cognom"+12+i,posicio);
            
            if(i<7){
                Girona.inserirJugador(j,"p");
                Barcelona.inserirJugador(j2,"p");
            }
            else{
                Girona.inserirJugador(j,"b");
                Barcelona.inserirJugador(j2,"b");
            }
        }


        Scanner entradaTeclat = new Scanner(System.in); // a java es fa aixi pels cin

        mostrarMenu(); // mostrem les opcions
        int opcio = entradaTeclat.nextInt(); // llegim de teclat

        while(opcio != EOS) {
            switch (opcio) {
                case 1:
                    System.out.println("Escull l'equip: Local (1) o Visitant (2)");
                    Scanner equipOpcio = new Scanner(System.in);

                    int nequip = equipOpcio.nextInt();
                    //sense controls de errors si ho fan malament surten del metode per pipiolos

                    if(nequip==1){
                        enviarMissatge(Girona);
                    }
                    else if(nequip==2){
                        enviarMissatge(Barcelona);
                    }
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
        System.out.println("Fi del programa!\uD83D\uDC80");
        System.exit(0);
    }

    private static void mostrarMenu() {
        System.out.println("OPCIONS DEL PROGRAMA:");
        System.out.println("1. Enviar missatge als jugadors de la pista");
        System.out.println("2. Amonestar un jugador");
        System.out.println("3. Canviar jugadors");
    }

    // opcio 1, falta implementar i posar els arguments
    private static void enviarMissatge(Equip equip) {
        System.out.println("Entra el missatge a enviar");
        Scanner sc =  new Scanner(System.in);
        String missatge = sc.nextLine();
        equip.enviarMissatge(missatge);
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

