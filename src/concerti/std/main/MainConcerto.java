package concerti.std.main;

import concerti.std.classes.Concerto;
import concerti.std.utilities.ScannerParsed;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

public class MainConcerto {

    private static Concerto creazioneConcerto(){
        boolean flag = false;
        Concerto concerto = null;
        while (!flag){
            try {
                String titolo = ScannerParsed.newString("inserire il titolo");
                LocalDate data = ScannerParsed.newDate();
                int postiTotali = ScannerParsed.getInteger("inserire i posti totali disponibili per la prenotazione ");
                LocalTime ora = ScannerParsed.newTime();
                BigDecimal prezzo = ScannerParsed.newBigDecimal("inserire il prezzo in formato ##.## ");

                concerto = new Concerto(titolo, data, postiTotali, ora, prezzo);
                flag = true;
            } catch (Exception e) {
                System.out.println("########################################################");
                System.out.println("l'inserimento non è andato a buon fine: "+e.getMessage());
                System.out.println("########################################################");
            }
        }
        return concerto;
    }

    public static void main(String[] args) {
        System.out.println("creazione concerto ");
        Concerto concerto = creazioneConcerto();
        System.out.println("concerto creato ");
        System.out.println(concerto.toString());
    }
}
