package federicoPoggi;

import federicoPoggi.Enteties.EventType;
import federicoPoggi.Enteties.Evento;
import federicoPoggi.EntetyDAO.EventoDAO;
import federicoPoggi.EntetyDAO.LocationDAO;
import federicoPoggi.EntetyDAO.PartecipationDAO;
import federicoPoggi.EntetyDAO.PersonDAO;

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
        LocationDAO lo=new LocationDAO(con);
        PersonDAO pe= new PersonDAO(con);
        PartecipationDAO par=new PartecipationDAO(con);

        con.close();
        maneger.close();
    }
}
