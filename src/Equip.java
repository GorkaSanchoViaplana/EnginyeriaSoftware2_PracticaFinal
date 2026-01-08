import java.util.Objects;
import java.util.Scanner;

public class Equip {
    private Jugador pista[];
    private Jugador banquillo[];
    private String Nom;
    private String Localitat;
    private EsquemaDefensa EsqDefensa;
    private EsquemaAtac EsqAtac;
    private Entrenador EntrenadorEquip;
    public void canviarFormacio(String Formacio){

    }

    public void inserirJugador(Jugador jug, String estat){
        if(estat.equals("p")){
            for(int i = 0; i < pista.length; i++){
                if(pista[i] == null){
                    pista[i] = jug;
                    EntrenadorEquip.donaAlta(jug);
                    break;
                }
            }
        } else if(estat.equals("b")){
            for(int i = 0; i < banquillo.length; i++){
                if(banquillo[i] == null){
                    banquillo[i] = jug;
                    break;
                }
            }
        }
    }

    public void mostarJugadorsEquip() {
        System.out.println("JUGADORS DE LA PISTA");
        for (Jugador jugador : pista) {
            jugador.mostrarJugador();
        }
        System.out.println("JUGADORS DEL BANQUILLO");
        for (Jugador jugador : banquillo) {
            jugador.mostrarJugador();
        }

    }

    /*public Jugador retornaJugador(String numFed) {
        // Cerca a la pista
        for (Jugador j : pista) {
            if (j != null && j.getNumFed().equals(numFed)) {
                return j;
            }
        }
        // Cerca al banquillo
        for (Jugador j : banquillo) {
            if (j != null && j.getNumFed().equals(numFed)) {
                return j;
            }
        }
        return null;
    }*/

    public void intercanviarJugadors() {
        Scanner scan = new Scanner(System.in);

        // Buscar jugador a la pista
        System.out.println("ENTRA UN JUGADOR DE LA PISTA");
        String jugPista = scan.nextLine();
        int posPista = cercarJugador(pista, jugPista);

        if (posPista == -1) {
            System.out.println("Jugador de la pista no trobat.");
            return;
        }

        // Buscar jugador al banquillo
        System.out.println("ENTRA UN JUGADOR DE LA BANCA PER SUBSTITUIR");
        String jugBanquillo = scan.nextLine();
        int posBanquillo = cercarJugador(banquillo, jugBanquillo);

        if (posBanquillo == -1) {
            System.out.println("Jugador del banquillo no trobat.");
            return;
        }

        // Intercanviar jugadors
        Jugador temp = pista[posPista];
        pista[posPista] = banquillo[posBanquillo];
        banquillo[posBanquillo] = temp;

        System.out.println("Jugadors intercanviats correctament.");
    }

    private int cercarJugador(Jugador[] array, String numFed) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null && array[i].getNumFed().equals(numFed)) {
                return i;
            }
        }
        return -1;
    }


    Equip(String nom, String localitat,Entrenador entrenadorEquip){
        this.pista= new  Jugador[7];
        this.banquillo= new  Jugador[5];
        this.Nom = nom;
        this.Localitat = localitat;
        this.EntrenadorEquip = entrenadorEquip; //No ens es important qui sigui el entrenador per tant fem un placeholder
    }
    public void enviarMissatge(String miss){
        EntrenadorEquip.donarOrdre(miss);
    }
}
