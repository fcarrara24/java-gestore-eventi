package concerti.std.main;

import concerti.std.classes.Evento;
import concerti.std.utilities.GestionePrenotazioni;
import concerti.std.utilities.ScannerParsed;

import java.time.LocalDate;

public class MainEvento {
    public static Evento creazioneEvento(){
        boolean flag = false;
        Evento evento = null;
        while (!flag){
            try {
                String titolo = ScannerParsed.newString("inserire il titolo\t\t\t\t\t\t");
                LocalDate data = ScannerParsed.newDate();
                int postiTotali = ScannerParsed.getInteger("inserire i posti totali disponibili \t\t\t");
                evento = new Evento(titolo, data, postiTotali);
                flag = true;
            } catch (Exception e) {
                System.out.println("########################################################");
                System.out.println("l'inserimento non è andato a buon fine: "+e.getMessage());
                System.out.println("########################################################");
            }
        }
        return evento;
    }


    public static void main(String[] args) {
        //test evento

        System.out.println("Gestore degli eventi: ");
        Evento evento = creazioneEvento();
        //stampa
        System.out.println(evento.toString());
        GestionePrenotazioni.cicloPrenotazioni(evento);
        GestionePrenotazioni.cicloDisdette(evento);
        System.out.println(GestionePrenotazioni.numeroPostiPrenotati(evento));
    }

}
