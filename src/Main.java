import java.util.Scanner;

public class Main {

    static final int EOS = 0; //End of support?? 😭💀
    public static void main(String[] args) {

        Partit partit = Partit.GetInstance(); //Singleton momento

        Entrenador EntrenadorGirona = new Entrenador( "Miguel Angel","Sanchez Muñoz","321312312AA");
        Equip Girona = new Equip("Girona","Girona",EntrenadorGirona);

        Entrenador EntrenadorBarcelona = new Entrenador("Hansi","Flick","123123123BB");
        Equip Barcelona = new Equip("Barcelona","Barcelona",EntrenadorBarcelona);

        Arbitre arbitreJefe = new Arbitre("Joan","Masaguer","1995380");
        Arbitre aribtreSuplent = new  Arbitre("Ismael","El Hassad","1995381");
        partit.setArbitres(arbitreJefe,aribtreSuplent);

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
        partit.setEquips(Barcelona,Girona); //Important ferho en aquest ordre sino estem acabats 💀💀💀

        Scanner entradaTeclat = new Scanner(System.in); // a java es fa aixi pels cin

        mostrarMenu(); // mostrem les opcions
        int opcio = entradaTeclat.nextInt(); // llegim de teclat

        while(opcio != EOS) {
            switch (opcio) {
                case 1:
                    System.out.println("Escull l'equip: Local (1) o Visitant (2)");
                    Scanner equipOpcio = new Scanner(System.in);
                    int nequip = equipOpcio.nextInt();
                    if(nequip==1){
                        enviarMissatge(partit,true);
                    }
                    else if(nequip==2){
                        enviarMissatge(partit,false);
                    }
                    break;
                case 2:
                    System.out.println("Jugadors Locals al Camp");
                    partit.mostrarJugadorsCamp(true);
                    System.out.println("Jugadors Visitants al Camp");
                    partit.mostrarJugadorsCamp(false);

                    System.out.println("Vols expulsar un jugador local(1) o un jugador visitant(2)?");
                    int local = entradaTeclat.nextInt();

                    if(local==1){
                        amonestarJugador(partit,true);
                    }else if(local==2){
                        amonestarJugador(partit,false);
                    }
                    break;
                case 3:
                    canviarJugadors(entradaTeclat, Girona, Barcelona);
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
    private static void enviarMissatge(Partit p,boolean local) {
        System.out.println("Entra el missatge a enviar");
        Scanner sc =  new Scanner(System.in);
        String missatge = sc.nextLine();
        p.enviarMissatge(local,missatge);
    }

    // opcio 2, falta implementar i posar els arguments
    private static void amonestarJugador(Partit p,boolean local) { //
        System.out.println("Entra el numFed del jugador a amonestar");
        Scanner sc =  new Scanner(System.in);
        String numFed = sc.nextLine();
        p.gestionarExpulsio(local,numFed);
    }

    // opcio 3, intercanviar jugadors dels equips
    private static void canviarJugadors(Scanner entradaTeclat, Equip local, Equip visitant) {
        System.out.println("CANVIAR JUGADORS");
        System.out.println("ENTRA UN EQUIP (1: LOCAL; 2: VISITANT)");

        int selEquip = entradaTeclat.nextInt();
        entradaTeclat.nextLine(); // Consumir el salt de línia pendent

        Equip equipSeleccionat = null;

        if (selEquip == 1) {
            equipSeleccionat = local;
            System.out.println("EQUIP LOCAL");
        } else if (selEquip == 2) {
            equipSeleccionat = visitant;
            System.out.println("EQUIP VISITANT");
        }

        equipSeleccionat.mostarJugadorsEquip();
        equipSeleccionat.intercanviarJugadors();
    }
}

