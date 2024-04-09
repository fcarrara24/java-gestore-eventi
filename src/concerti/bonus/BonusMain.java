package concerti.bonus;

import concerti.std.classes.Concerto;
import concerti.std.classes.Evento;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

public class BonusMain {
    public static void main(String[] args) {
        // creazione lista gestore lista
        ProgrammEventi pr = new ProgrammEventi( "programma eventi");

        //aggiunta di elementi alla lista
        pr.addEvento(new Evento("evento 1", LocalDate.parse("2024-08-09"), 1000 ));
        pr.addEvento(new Evento("evento 2", LocalDate.parse("2024-08-09"), 2000 ));
        pr.addEvento(new Evento("evento 3", LocalDate.parse("2025-08-09"), 1000 ));
        pr.addEvento(new Concerto("concerto 1", LocalDate.parse("2024-08-09"), 1000, LocalTime.of(23, 45), new BigDecimal(12.45)));
        pr.addEvento(new Concerto("concerto 2", LocalDate.parse("2026-08-09"), 2000, LocalTime.of(12, 1), new BigDecimal(12.4)));
        //conto il numero di eventi o concerti inseriti nella lista
        System.out.println("totale eventi "+pr.contaEventi()+"\n\n");

        // cerco gli eventi/ concerti avvenuti il  2024-04-09
        System.out.println("lista eventi 2024-04-09: \n");
        pr.listaEventiData(LocalDate.parse("2024-08-09")).forEach(evento -> System.out.println(evento.toString()));

        // ordino in dal piu prossimo al piu remoto gli eventi e i concerti
        System.out.println("\n\nlista eventi ordinata per data (crescente): ");
        System.out.println(pr.orderedEvents());

        //svuoto la lista degli eventi e stampo il risultato di questa
        pr.svuotaLista();
        System.out.println("\n\nlista svuotata " +pr.contaEventi());
    }

}
