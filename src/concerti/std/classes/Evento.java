package concerti.std.classes;

import concerti.std.utilities.DateUtilities;

import java.time.LocalDate;

public class Evento {
    private String titolo;
    private LocalDate data;
    private int postiTotali;
    private int postiPrenotati;

    //constructor
    public Evento(String titolo, LocalDate data, int postiTotali ) throws IllegalArgumentException {
        if(! DateUtilities.isntPassed(data))
            throw new IllegalArgumentException("La data dell'evento che stai cercando di inserire è gia passata");
        else if(postiTotali < 0)
            throw new IllegalArgumentException("i posti disponibili per l'evento non possono essere negativi");
        this.titolo = titolo;
        this.data = data;
        this.postiTotali = postiTotali;
        this.postiPrenotati = 0;
    }

    //getters and setters


    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public void setData(LocalDate data) throws IllegalArgumentException {
        if(! DateUtilities.isntPassed(data))
            throw new IllegalArgumentException("La data dell'evento che stai cercando di inserire è gia passata");
        this.data = data;
    }

    //getters


    public int getPostiTotali() {
        return postiTotali;
    }

    public int getPostiPrenotati() {
        return postiPrenotati;
    }

    public LocalDate getData() {
        return data;
    }
    public String getStringData(){
        return DateUtilities.longFormatDate(this.data);
    }
    //methods
    public void prenota(int nPostiDaPrenotare) throws IllegalArgumentException{
        if(! DateUtilities.isntPassed(data))
            throw new IllegalArgumentException("L'evento è gia passato");
        if(nPostiDaPrenotare<0 || nPostiDaPrenotare > (this.postiTotali - this.postiPrenotati)){
            throw new IllegalArgumentException("non puoi prenotare "+nPostiDaPrenotare+" sono disponibili solo "+(this.postiTotali - this.postiPrenotati));
        }
        this.postiPrenotati += nPostiDaPrenotare;
    }

    public void disdici(int nPostiDaDisdire) throws IllegalArgumentException{
        if(! DateUtilities.isntPassed(data))
            throw new IllegalArgumentException("L'evento è gia passato");
        if(nPostiDaDisdire<0 || nPostiDaDisdire > (this.postiPrenotati)){
            throw new IllegalArgumentException("non puoi disdire "+nPostiDaDisdire+" sono stati prenotati solo "+this.postiPrenotati);
        }
        this.postiPrenotati -= nPostiDaDisdire;
    }

    public boolean isSameDate(LocalDate searchDate){
        // ritorna true se le date sono uguali
        return searchDate.isEqual(this.data);
    }

    // toString


    @Override
    public String toString() {
        String longDate = DateUtilities.longFormatDate(data);
        return   longDate +
                " - " + titolo;
    }
}


