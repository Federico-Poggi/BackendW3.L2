package federicoPoggi.EntetyDAO;

import federicoPoggi.Enteties.EventType;
import federicoPoggi.Enteties.Evento;
import federicoPoggi.Enteties.Location;
import federicoPoggi.Exception.NotInDataBaseException;
import javax.persistence.*;
import java.util.Scanner;

public class EventoDAO {
    public final EntityManager con;
    public EventoDAO(EntityManager con){this.con=con;}


    public void save(Evento evento) throws NotInDataBaseException {
        Scanner scan=new Scanner(System.in);
        EntityTransaction transaction = con.getTransaction(); //avvio transazione
        transaction.begin();

        con.persist(evento);

        transaction.commit();
    };

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
            if(numeroEveEliminati==0){
                System.out.println("Il nome"+" "+ "'"+eventTitle+"'" +" non esiste:\n -Terminare operazione (PRESS T)\n -Reinserire nome (PRESS R)");
            }
            ev.commit();
        }catch (Exception e){
            throw new RuntimeException("Non valido");
        }finally {
            con.close();
        }







    }






}
