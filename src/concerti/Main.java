package concerti;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static Evento evento;

    private static String stringMessage(String message){
        Scanner sc = new Scanner(System.in);
        System.out.print(message);
        return sc.nextLine();
    }

    private static LocalDate newDate(){
        boolean flag = false;
        LocalDate trueData = null;
        do {
            try{
                String data = stringMessage("inserire la data in formato yyyy-mm-dd");
                trueData = LocalDate.parse(data);
                // if localdate dowsnt throw exception
                flag =true;
            } catch (DateTimeParseException e){
                System.out.println("la data non è in formato valido");
            }
        } while(!flag);

        return trueData;
    }

    private static int getNumber(String message){
        boolean flag = false;
        int postiTotali = 0;
        while(!flag){
            try {
                postiTotali = Integer.parseInt(stringMessage(message));
                flag = true;
            }
            catch (Exception e){
                System.out.println("inserire un numero valido");
            }

        }
        return postiTotali;
    }

//    private static boolean getBoolean(String message){
//        boolean flag = false;
//        boolean outVariable = true;
//        while(!flag){
//            try {
//                outVariable = Boolean.parseBoolean(stringMessage(message));
//                flag = true;
//            }
//            catch (Exception e){
//                System.out.println("inserire true o false");
//            }
//
//        }
//        return outVariable;
//    }
    private static Evento gestoreInserimento(){
        boolean flag = false;
        Evento evento = null;
        while (!flag){
            try {
                String titolo = stringMessage("inserire il titolo");
                LocalDate data = newDate();
                int postiTotali = getNumber("inserire i posti totali disponibili per la prenotazione ");
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

    public static void prenotaODisdici(boolean aggiungi){
        int posti = getNumber("inserire il numero di posti da "+(aggiungi? "prenotare ":"disdire "));
        try {
            if(aggiungi) evento.prenota(posti);
            else evento.disdici(posti);
        } catch (Exception e){
            System.out.println("########################################################");
            System.out.println("l'operazione non è andata a buon fine: "+e.getMessage());
            System.out.println("########################################################");
        }
    }

    public static String numeroPostiPrenotati(){
        String outString = "Il numero di posti occupati è di "+evento.getPostiPrenotati()+" su "+evento.getPostiTotali();
        return outString;
    }

    public static void cicloPrenotazioni(){
        System.out.println("\n\nprenotazioni");
        boolean continua = true;
        while(continua){
            prenotaODisdici(true);
            // stampo il totale delle prenotazioni
            System.out.println(numeroPostiPrenotati());
            continua = Boolean.parseBoolean(stringMessage("desidera continuare con le prenotazioni {true/altro} "));
        }
    }



    public static void cicloDisdette(){
        System.out.println("\n\ndisdette");
        boolean continua = true;
        while(continua){
            prenotaODisdici(false);
            // stampo il totale delle disdette
            System.out.println(numeroPostiPrenotati());
            continua = Boolean.parseBoolean(stringMessage("desidera continuare a disdire {true/altro} "));
        }
    }






    public static void main(String[] args) {

        System.out.println("Gestore degli eventi: ");
        evento = gestoreInserimento();
        //stampa
        System.out.println(evento.toString());
        // ciclo prenotazioni
        cicloPrenotazioni();
        // ciclo disdette
        cicloDisdette();
        System.out.println("\n\nfine disdette\n\n");
        System.out.println(numeroPostiPrenotati());
    }
}
