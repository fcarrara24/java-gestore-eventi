package concerti.std.utilities;

import concerti.std.classes.Evento;

public class GestionePrenotazioni {

    public static Evento prenotaODisdici(boolean aggiungi, Evento evento){
        int posti = ScannerParsed.getInteger("inserire il numero di posti da "+(aggiungi? "prenotare ":"disdire "));
        try {
            if(aggiungi) evento.prenota(posti);
            else evento.disdici(posti);
        } catch (Exception e){
            System.out.println("########################################################");
            System.out.println("l'operazione non è andata a buon fine: "+e.getMessage());
            System.out.println("########################################################");
        }

        return evento;
    }

    public static String numeroPostiPrenotati(Evento evento){
        String outString = "Il numero di posti occupati è di "+evento.getPostiPrenotati()+" su "+evento.getPostiTotali();
        return outString;
    }

    public static void cicloPrenotazioni(Evento evento){
        System.out.println("\n\nprenotazioni");
        boolean continua = true;
        while(continua){
            prenotaODisdici(true, evento);
            // stampo il totale delle prenotazioni
            System.out.println(numeroPostiPrenotati(evento));
            continua = Boolean.parseBoolean(ScannerParsed.newString("desidera continuare con le prenotazioni {true/altro} "));
        }
    }



    public static void cicloDisdette(Evento evento){
        System.out.println("\n\ndisdette");
        boolean continua = true;
        while(continua){
            prenotaODisdici(false, evento);
            // stampo il totale delle disdette
            System.out.println(numeroPostiPrenotati(evento));
            continua = Boolean.parseBoolean(ScannerParsed.newString("desidera continuare a disdire {true/altro} "));
        }
    }
}
