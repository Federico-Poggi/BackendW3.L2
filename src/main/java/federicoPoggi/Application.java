package federicoPoggi;

import federicoPoggi.Enteties.EventType;
import federicoPoggi.Enteties.Evento;
import federicoPoggi.EntetyDAO.EventoDAO;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Parameter;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;
import java.util.List;


public class Application {
    private static final EntityManagerFactory maneger= Persistence.createEntityManagerFactory("Backend-W3.L2");
    public static void main(String[] args) {
        EntityManager con=maneger.createEntityManager(); //responsabile dell'esecuzioni di operazioni con il database
        EventoDAO ev=new EventoDAO(con);




        Evento event=new Evento("Concerto Queen", "1-05-23", 500000, EventType.PUBBLICO);

        con.close();
        maneger.close();
    }
}
