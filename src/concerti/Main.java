package concerti;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
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

    private static LocalTime newTime(){
        boolean flag = false;
        LocalTime trueTime = null;
        do{
            try{
                String data = stringMessage("Inserisci l'orario (formato hh:mm)");
                // splitting array to get hours and minutes
                String[] parts = data.split(":");
                trueTime = LocalTime.of(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]));
                // if localtime throw exception flag stays false
                if(trueTime instanceof LocalTime){
                    flag =true;
                }
            } catch (Exception e){
                System.out.println("la data non è in formato valido");
            }
        } while (!flag);
        return trueTime;
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

    private static  BigDecimal newBigDecimal(String message){
        boolean flag = false;
        BigDecimal postiTotali = null;
        while(!flag){
            try {
                postiTotali = new BigDecimal(stringMessage(message));
                flag = true;
            }
            catch (Exception e){
                System.out.println("inserire un numero valido");
            }

        }
        return postiTotali;
    }

    private static Concerto creazioneConcerto(){
        boolean flag = false;
        Concerto concerto = null;
        while (!flag){
            try {
                String titolo = stringMessage("inserire il titolo");
                LocalDate data = newDate();
                int postiTotali = getNumber("inserire i posti totali disponibili per la prenotazione ");
                LocalTime ora = newTime();
                BigDecimal prezzo = newBigDecimal("inserire il prezzo in formato ##.## ");

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






//    public static void main(String[] args) {
//        //test evento
//
//        System.out.println("Gestore degli eventi: ");
//        evento = gestoreInserimento();
//        //stampa
//        System.out.println(evento.toString());
//        cicloPrenotazioni();
//        cicloDisdette();
//        System.out.println(numeroPostiPrenotati());
//
//        // test Concerto
//
//        System.out.println("gestore concerti");
//        Concerto concerto = creazioneConcerto();
//        System.out.println("concerto creato");
//        System.out.println(concerto.toString());
//
//
//    }

    public static void main(String[] args) {
        ProgrammEventi pr = new ProgrammEventi( "programma eventi");

            pr.addEvento(new Evento("evento 1", LocalDate.parse("2024-08-09"), 1000 ));
            pr.addEvento(new Evento("evento 2", LocalDate.parse("2024-08-09"), 2000 ));
            pr.addEvento(new Evento("evento 3", LocalDate.parse("2025-08-09"), 1000 ));
            pr.addEvento(new Concerto("concerto 1", LocalDate.parse("2024-08-09"), 1000, LocalTime.of(23, 45), new BigDecimal(12.45)));
            pr.addEvento(new Concerto("concerto 2", LocalDate.parse("2026-08-09"), 2000, LocalTime.of(12, 1), new BigDecimal(12.4)));
            System.out.println("totale eventi "+pr.contaEventi()+"\n\n");
            System.out.println("lista eventi 2024-04-09: \n");
            pr.listaEventiData(LocalDate.parse("2024-08-09")).forEach(evento -> System.out.println(evento.toString()));
            System.out.println("\n\nlista eventi ordinata per data (crescente): ");
            System.out.println(pr.orderedEvents());
            pr.svuotaLista();
            System.out.println("\n\nlista svuotata " +pr.contaEventi());
    }






}
