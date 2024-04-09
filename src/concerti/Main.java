package concerti;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static String stringMessage(String message){
        Scanner sc = new Scanner(System.in);
        System.out.println(message);
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
    private static Evento gestoreInserimento(){
        boolean flag = false;
        Evento evento = null;
        while (!flag){
            try {
                String titolo = stringMessage("inserire il titolo");
                LocalDate data = newDate();
                int postiTotali = getNumber("inserire i posti totali disponibili per la prenotazione");
                evento = new Evento(titolo, data, postiTotali);
                flag = true;
            } catch (Exception e) {
                System.out.println("l'inserimento non è andato a buon fine: "+e.getMessage());
            }
        }
        return evento;
    }
    public static void main(String[] args) {
        List<Evento> eventi = new ArrayList<>();
        System.out.println("Gestore degli eventi: ");
        eventi.add(gestoreInserimento());
        System.out.println(eventi.get(0).toString());
    }
}
