package federicoPoggi;

import federicoPoggi.Enteties.EventType;
import federicoPoggi.Enteties.Evento;
import federicoPoggi.EntetyDAO.EventoDAO;
import org.hibernate.SessionFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.swing.text.html.parser.Entity;

import federicoPoggi.EntetyDAO.HibernateUtil;


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

        try{
            CriteriaBuilder cr = maneger.getCriteriaBuilder();
            CriteriaQuery<Evento> cl = cr.createQuery(Evento.class);
            Root<Evento> from = cl.from(Evento.class);
            cr.selectCase(from.get(event.getEvent_title()));
        }catch (Exception e){
            throw new RuntimeException(e);
        }

        con.close();
        maneger.close();
    }
}
