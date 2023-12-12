package federicoPoggi.EntetyDAO;

import federicoPoggi.Enteties.Evento;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

public class EventoDAO {

    public final EntityManager con;
    public EventoDAO(EntityManager con){this.con=con;}

    public void save(Evento event){
       EntityTransaction transaction = con.getTransaction(); //avvio transazione

        transaction.begin();

        con.persist(event);

        transaction.commit();

        System.out.println(event.getEvent_title() +  " è stato Aggiunto alla lista");
    };

    public Evento getById(long id_event){
        Evento getEv=con.find(Evento.class, id_event);
        return getEv;
    };

    public void delete(String event){
        EntityTransaction ev= con.getTransaction();
        ev.begin();
        con.remove(event);
        ev.commit();

    }

}