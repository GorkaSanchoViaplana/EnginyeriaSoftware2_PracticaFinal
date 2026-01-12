import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    static final int EOS = 0; //End of support?? 😭💀
    public static void main(String[] args) throws FileNotFoundException {
        InicialitzarDesdeFitxer();
        Partit partit = Partit.GetInstance();


        Scanner entradaTeclat = new Scanner(System.in); // a java es fa aixi pels cin

        mostrarMenu(); // mostrem les opcions
        int opcio = entradaTeclat.nextInt(); // llegim de teclat

        while(opcio != EOS) {
            switch (opcio) {
                case 1:
                    System.out.println("Escull l'equip: Local (1) o Visitant (2)");
                    int nequip = entradaTeclat.nextInt();
                    entradaTeclat.nextLine();
                    if(nequip==1){
                        enviarMissatge(partit,true,entradaTeclat);
                    }
                    else if(nequip==2){
                        enviarMissatge(partit,false,entradaTeclat);
                    }
                    break;
                case 2:
                    System.out.println("Jugadors Locals al Camp");
                    partit.mostrarJugadors(true);
                    System.out.println("Jugadors Visitants al Camp");
                    partit.mostrarJugadors(false);

                    System.out.println("Vols amonestar un jugador local(1) o un jugador visitant(2)?");
                    int local = entradaTeclat.nextInt();
                    entradaTeclat.nextLine();
                    if(local==1){
                        amonestarJugador(partit,true,entradaTeclat);
                    }else if(local==2){
                        amonestarJugador(partit,false,entradaTeclat);
                    }
                    break;
                case 3:
                    canviarJugadors(entradaTeclat, partit);
                    break;
            }

            mostrarMenu();
            opcio = entradaTeclat.nextInt();
            entradaTeclat.nextLine();
        }
        System.out.println("Fi del programa!"); //💔🥀
        System.exit(0);
    }
    private static void Inicialitza(){
        Partit partit = Partit.GetInstance(); //Singleton momento 💔💔💔

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
            Jugador j2=new Jugador(""+(12+i),"nom"+(12+i),"cognom"+(12+i),posicio);

            if(i<7){ //Seran 7 al camp ( 6 pista 1 porter)
                Girona.inserirJugador(j,"p");
                Barcelona.inserirJugador(j2,"p");
            }
            else{
                Girona.inserirJugador(j,"b");
                Barcelona.inserirJugador(j2,"b");
            }
        }
        partit.setEquips(Barcelona,Girona); //Important ferho en aquest ordre sino estem acabats 💀💀💀
    }

    private static void InicialitzarDesdeFitxer() throws FileNotFoundException {

        Partit partit = Partit.GetInstance();
        Equip Girona = new Equip();
        Equip Barcelona = new Equip();
        Entrenador palceHolder = null;
        Arbitre a1 =null;
        Arbitre a2 =  null;
        try (BufferedReader br = new BufferedReader(new FileReader("partit"))){
            String line;
            while((line = br.readLine()) != null){
                if(line.isEmpty()){continue;}
                String[] lineSplit = line.split(";"); //Es el separador q tenim al fitxes aixi q no tocar aixo
                switch(lineSplit[0]){
                    case "ENTRENADOR":
                        Entrenador e = new Entrenador(lineSplit[2],lineSplit[3],lineSplit[4]);
                        if(lineSplit[1].equals("Girona")){ //Molt important doncs que Equip estigui abans que entrenador al .txt
                            Girona.setEntrenadorEquip(e);
                        }else{
                            Barcelona.setEntrenadorEquip(e);
                        }
                        break;
                    case "JUGADOR":
                        Posicio pos = new Posicio(1,1,1);
                        Jugador j = new Jugador(lineSplit[2],lineSplit[3],lineSplit[4],pos);
                        Rol r = null;
                        if(lineSplit.length > 6){
                            r = retornaRol(lineSplit[6]);
                        }else{ //Vale per alguna rao hi ha un jugador sense rol o algo aixi detecta el programa, fem aixo i ja
                            //System.out.println("Jugador amb rol = null");
                            r = retornaRol("banquillo"); //Farem que banquillo sigui un rol per defecte
                        }
                        j.canviaRol(r);
                        if(lineSplit[1].equals("Girona")){
                            Girona.inserirJugador(j,lineSplit[5]);
                        }else{
                            Barcelona.inserirJugador(j,lineSplit[5]);
                        }
                        break;
                    case "EQUIP":
                        if(lineSplit[1].equals("Girona")){
                            Girona.setNom(lineSplit[1]);
                            Girona.setLocalitat(lineSplit[2]);
                        }else{
                            Barcelona.setNom(lineSplit[1]);
                            Barcelona.setLocalitat(lineSplit[2]);
                        }
                        break;
                    case "ARBITRE":
                        Arbitre a =  new Arbitre(lineSplit[2],lineSplit[3],lineSplit[4]);
                        if(lineSplit[1].equals("PRINCIPAL")){
                            a1 = a;
                        }else{
                            a2 = a;
                        }
                        break;
                }
            }

            partit.setEquips(Barcelona,Girona);
            partit.setArbitres(a1,a2);

        } catch (IOException e) {
            System.out.println("Error al iniciar partit.txt");
            throw new RuntimeException(e);
        }

    }
    private static void mostrarMenu() {
        System.out.println("OPCIONS DEL PROGRAMA:");
        System.out.println("1. Enviar missatge als jugadors de la pista");
        System.out.println("2. Amonestar un jugador");
        System.out.println("3. Canviar jugadors");
    }

    // opcio 1, falta implementar i posar els arguments
    private static void enviarMissatge(Partit p,boolean local,Scanner sc) {
        System.out.println("Entra el missatge a enviar");
        String missatge = sc.nextLine();
        p.enviarMissatge(local,missatge);
    }

    // opcio 2, falta implementar i posar els arguments
    private static void amonestarJugador(Partit p,boolean local,Scanner sc) { //
        System.out.println("Entra el numFed del jugador a amonestar");
        String numFed = sc.nextLine();
        System.out.println("Quin arbitre fica la falta (1 o 2)");
        int nArbitreFalta = sc.nextInt();
        if(nArbitreFalta>2 || nArbitreFalta<1){
            System.out.println("Arbitre incorrecte");
            return;
        }
        p.gestionarExpulsio(local,numFed,nArbitreFalta);
    }

    // opcio 3, intercanviar jugadors dels equips
    private static void canviarJugadors(Scanner entradaTeclat, Partit p) {
        System.out.println("CANVIAR JUGADORS");
        System.out.println("ENTRA UN EQUIP (1: LOCAL; 2: VISITANT)");

        int selEquip = entradaTeclat.nextInt();
        entradaTeclat.nextLine();

        boolean equipSeleccionat = false;

        if (selEquip == 1) {
            equipSeleccionat = true;
            System.out.println("EQUIP LOCAL");
        } else if (selEquip == 2) {
            equipSeleccionat = false;
            System.out.println("EQUIP VISITANT");
        } else System.out.println("Equip incorrecte");

        p.mostrarJugadors(equipSeleccionat);

        System.out.println("ENTRA UN JUGADOR DE LA PISTA:");
        String JugPartit = entradaTeclat.nextLine();

        System.out.println("ENTRA UN JUGADOR DEL BANQUILLO:");
        String JugBanquillo = entradaTeclat.nextLine();

        p.intercanviarJugadors(equipSeleccionat, JugPartit, JugBanquillo);
    }

    private static Rol retornaRol(String nomRol){
        Rol r = null;
        nomRol = nomRol.toLowerCase();
        switch (nomRol){
            case "centrala":
                r = new CentralA();
                break;
            case "centrald":
                r = new CentralD();
                break;
            case "centraldretd":
                r = new CentralDretD();
                break;
            case "centralesquerrad":
                r = new CentralEsquerraD();
                break;
            case "extremdreta":
                r = new ExtremDretA();
                break;
            case "extremdretd":
                r = new ExtremDretD();
                break;
            case "extremesquerraa":
                r = new ExtremEsquerraA();
                break;
            case "extremesquerrad":
                r = new ExtremEsquerraD();
                break;
            case "lateraldreta":
                r = new LateralDretA();
                break;
            case "lateraldretd":
                r = new LateralDretD();
                break;
            case "lateralesquerraa":
                r = new LateralEsquerraA();
                break;
            case "lateralesquerrad":
                r = new LateralEsquerraD();
                break;
            case "pivota":
                r = new PivotA();
                break;
            case "porter":
                r = new Porter();
                break;
            case "avancatd":
                r = new AvancatD();
                break;
            case "banquillo":
                r = new BanquilloRol();
                break;
            default:
                System.out.println("Rol no reconegut: " + nomRol);
                break;
        }
        return r;
    }
}

