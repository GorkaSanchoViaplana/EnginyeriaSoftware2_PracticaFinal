import java.time.Instant;
import java.util.ArrayList;

public class Sancio {
    private String TipusSancio;
    private Jugador Sancionat;
    private Instant HoraExpulsio;
    private String arbitIden;
    public Sancio(String targeta,Jugador j,Instant data,String arbit){
        this.TipusSancio=targeta;
        this.Sancionat=j;
        this.HoraExpulsio=data; //Aixo ho ignorarem completament a la practica
        this.arbitIden=arbit;
    }

    public Sancio() {

    }

    public String getTipusSancio() {
        return TipusSancio;
    }
    public Jugador getSancionat() {
        return Sancionat;
    }
    public Instant getHoraExpulsio() {
        return HoraExpulsio;
    }
    public String getArbitIden() {return arbitIden;}
}
