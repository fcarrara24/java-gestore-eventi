package concerti.std.classes;

import concerti.std.utilities.DateUtilities;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.LocalTime;

public class Concerto extends Evento {

    private static final BigDecimal zero = new BigDecimal(0);
    private LocalTime ora;
    private BigDecimal prezzo;
    //constructor


    public Concerto(String titolo, LocalDate data, int postiTotali, LocalTime ora, BigDecimal prezzo) throws IllegalArgumentException {
        super(titolo, data, postiTotali);
        if(data.isEqual(LocalDate.now()) && LocalTime.now().isAfter(ora)){
            throw new IllegalArgumentException("l'ora che desideri inserire è gia passata");
        } else if(prezzo.compareTo(zero) < 0){
            throw new IllegalArgumentException("il prezzo del concerto non puo essere negativo");
        }
        this.ora = ora;
        this.prezzo = prezzo;
    }

    //getters
    public String getOra() {
        return DateUtilities.formattedTime(ora);
    }

    public String getPrezzo() {
        return prezzo.setScale(2, RoundingMode.HALF_EVEN)+"€";
    }

    //setters


    public void setOra(LocalTime ora) {
        if(super.getData().isEqual(LocalDate.now()) && ora.isAfter(LocalTime.now())){
            throw new IllegalArgumentException("l'ora che desideri inserire è gia passata");
        }
        this.ora = ora;
    }

    public void setPrezzo(BigDecimal prezzo) {
        if(prezzo.compareTo(zero) < 0){
            throw new IllegalArgumentException("lil prezzo del concerto non puo essere negativo");
        }
        this.prezzo = prezzo;
    }

    // toString

    @Override
    public String toString() {
        return super.getStringData()+" "+this.getOra()+" - "+super.getTitolo()+" - "+this.getPrezzo();
    }
}
