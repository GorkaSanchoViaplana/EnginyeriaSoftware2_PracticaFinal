import java.util.Date;

public class Sancio {
    private String TipusSancio;
    private Jugador Sancionat;
    private Date HoraExpulsio;
    public Sancio(String targeta,Jugador j,Date data){
        this.TipusSancio=targeta;
        this.Sancionat=j;
        this.HoraExpulsio=data;
    }
    public String getTipusSancio() {
        return TipusSancio;
    }
    public Jugador getSancionat() {
        return Sancionat;
    }
    public Date getHoraExpulsio() {
        return HoraExpulsio;
    }
}
