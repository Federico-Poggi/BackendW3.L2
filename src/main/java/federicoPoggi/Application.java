package federicoPoggi;

import federicoPoggi.Enteties.EventType;
import federicoPoggi.Enteties.Evento;
import federicoPoggi.EntetyDAO.EventoDAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Application {

    private static final EntityManagerFactory maneger= Persistence.createEntityManagerFactory("Backend-W3.L2");
    public static void main(String[] args) {
        EntityManager con=maneger.createEntityManager(); //responsabile dell'esecuzioni di operazioni con il database

        EventoDAO ev=new EventoDAO(con);
        Evento event=new Evento("Mercatino Natalizio", "1-12-23", 500000, EventType.PUBBLICO);

        try {
            ev.save(event);
        }catch (Exception e){
            throw new RuntimeException();
        }
            ev.getById(event.getEvent_id());


        con.close();
        maneger.close();
    }
}
