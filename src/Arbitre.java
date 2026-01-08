import java.time.Instant;

public class Arbitre extends Participants{
    private Posicio Pos;

    public Arbitre(String nom, String cognom, String numfed) {
        this.Pos = new Posicio(0,0,0); //Iniciara al centre del camp
        this.NumFed = numfed;
        this.Nom = nom;
        this.Cognom = cognom;
    }

    public Sancio SancionarGroga(Jugador j) {
        Instant instant = Instant.now(); //Aixo estara en un format raro pero es lo que hay
        Sancio groga = new Sancio("Groga",j,instant,this.NumFed);
        return groga;
    }

    public void SancionarTaronja(Jugador j) {

    }

    public void SancionarVermella(Jugador j) {

    }

}
