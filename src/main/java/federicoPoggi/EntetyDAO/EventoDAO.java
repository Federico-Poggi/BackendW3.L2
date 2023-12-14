package federicoPoggi.EntetyDAO;

import federicoPoggi.Enteties.Concert;
import federicoPoggi.Enteties.EventType;
import federicoPoggi.Enteties.Evento;
import federicoPoggi.Enteties.Location;
import federicoPoggi.Exception.NotInDataBaseException;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class EventoDAO {
    public final EntityManager con;
    public EventoDAO(EntityManager con){this.con=con;}


    public void save(Evento evento, Location location) throws NotInDataBaseException {
        Scanner scan=new Scanner(System.in);
        EntityTransaction transaction = con.getTransaction(); //avvio transazione
        transaction.begin();

        con.persist(location);

        con.persist(evento);

        transaction.commit();
    };


    public void getConcertStreaming (boolean value) throws NotInDataBaseException{
        Query queryGet=con.createQuery("SELECT Evento FROM Concert where streaming = :valore");
        try{
            con.getTransaction().begin();
            List concertList=new ArrayList<>();
            queryGet.setParameter("valore", value);
            concertList = queryGet.getResultList();
            concertList.forEach(System.out::println);
        }catch (RuntimeException e){
            throw new RuntimeException(e);
        }

    }



    public Evento getById(long id_event){
        Evento getEv=con.find(Evento.class, id_event);
        return getEv;
    };




    public void delete(String eventTitle){
        Query queryDelete=con.createQuery("DELETE Evento WHERE event_title = :eventTitle");
        EntityTransaction ev= con.getTransaction();
        try{
            ev.begin();
            queryDelete.setParameter("eventTitle", eventTitle);
            int numeroEveEliminati= queryDelete.executeUpdate();
            System.out.println(numeroEveEliminati);
            ev.commit();
            /*if(numeroEveEliminati==0){
                System.out.println("Il nome"+" "+ "'"+eventTitle+"'" +" non esiste:\n -Terminare operazione (PRESS T)\n -Reinserire nome (PRESS R)");
            }*/

        }catch (Exception e){
            throw new RuntimeException("Non valido");
        }






    }






}
