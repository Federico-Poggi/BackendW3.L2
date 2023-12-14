package federicoPoggi.EntetyDAO;

import federicoPoggi.Enteties.Events;
import federicoPoggi.Enteties.Location;
import federicoPoggi.Exception.NotInDataBaseException;
import javax.persistence.*;
import java.util.Scanner;

public class EventsDAO {
    public final EntityManager con;
    public EventsDAO(EntityManager con){this.con=con;}


    public void save(Events evento) throws NotInDataBaseException {
        EntityTransaction transaction = con.getTransaction(); //avvio transazione
        transaction.begin();
        con.persist(evento);
        transaction.commit();
    };





    public Events getById(long id_event){
        return con.find(Events.class, id_event);
    };




    public void delete(String eventTitle){
    }






}
