package concerti.std.utilities;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class DateUtilities {
    /**
     * return true if the date is not passed yet
     * @param date
     * @return
     */
    public static Boolean isntPassed(LocalDate date){
        LocalDate now = LocalDate.now();
        int notPassed = date.compareTo(now);
        return (notPassed >= 0);
    }

    /**
     * retruns date in long format (17 February 2022)
     * @param date
     * @return
     */
    public static String longFormatDate(LocalDate date) {
        DateTimeFormatter df = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG);
        String formattedDate = df.format(date);
        return formattedDate;
    }

    /**
     * returns formatted time
     * @param time
     * @return
     */
    public static String formattedTime(LocalTime time){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        String formattedTime = time.format(formatter);
        return formattedTime;
    }
}
