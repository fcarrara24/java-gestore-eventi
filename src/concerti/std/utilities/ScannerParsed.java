package concerti.std.utilities;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class ScannerParsed {
    public static String newString(String message){
        Scanner sc = new Scanner(System.in);
        System.out.print(message);
        return sc.nextLine();
    }

    public static LocalDate newDate(){
        boolean flag = false;
        LocalDate trueData = null;
        do {
            try{
                String data = newString("inserire la data in formato yyyy-mm-dd ");
                trueData = LocalDate.parse(data);
                // if localdate dowsnt throw exception
                flag =true;
            } catch (DateTimeParseException e){
                System.out.println("la data non è in formato valido");
            }
        } while(!flag);

        return trueData;
    }

    public static LocalTime newTime(){
        boolean flag = false;
        LocalTime trueTime = null;
        do{
            try{
                String data = newString("Inserisci l'orario (formato hh:mm)");
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

    public static int getInteger(String message){
        boolean flag = false;
        int postiTotali = 0;
        while(!flag){
            try {
                postiTotali = Integer.parseInt(newString(message));
                flag = true;
            }
            catch (Exception e){
                System.out.println("inserire un numero valido");
            }

        }
        return postiTotali;
    }



    public static BigDecimal newBigDecimal(String message){
        boolean flag = false;
        BigDecimal postiTotali = null;
        while(!flag){
            try {
                postiTotali = new BigDecimal(newString(message));
                flag = true;
            }
            catch (Exception e){
                System.out.println("inserire un numero valido");
            }

        }
        return postiTotali;
    }
}
