package concerti.bonus;

import concerti.std.classes.Evento;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ProgrammEventi {
    private String titolo;
    private List<Evento> eventi;

    public ProgrammEventi(String titolo) {
        this.titolo = titolo;
        this.eventi = new ArrayList<>();
    }

    /**
     * add e to list eventi
     * @param e
     */
    public void addEvento(Evento e){
        eventi.add(e);
    }

    /**
     * ritorna il numero di eventigia preseti nella lista
     * @return
     */
    public int contaEventi(){
        return eventi.size();
    }

    /**
     * svuota gli eventi presenti nella lista
     */
    public void svuotaLista(){
        this.eventi = new ArrayList<>();
    }

    /**
     * given a certain date it returns the list of <Evento> containing that date
     * @param date
     * @return
     */
    public List<Evento> listaEventiData(LocalDate date){
        //searching for events that have the same date
        List<Evento> outlist =  eventi.stream().filter(e -> e.isSameDate(date)).collect(Collectors.toList());
        return outlist;
    }

    /**
     * order events by date and return them in string format <br> data - titolo <br> data - titolo <br> data - titolo
     * @return
     */
    public String orderedEvents(){
        this.eventi.sort((a, b) -> (a.getData().compareTo(b.getData())));
        StringBuilder outString = new StringBuilder();
        for(Evento evento : this.eventi){
            outString.append(evento.getData()).append(" - ").append(evento.getTitolo()).append("\n");
        }
        return outString.toString();
    }

}
