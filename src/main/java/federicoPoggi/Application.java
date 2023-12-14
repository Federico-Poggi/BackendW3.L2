package federicoPoggi;
import federicoPoggi.Enteties.AthleticCompetition;
import federicoPoggi.Enteties.EventType;
import federicoPoggi.Enteties.Location;
import federicoPoggi.EntetyDAO.*;
import federicoPoggi.Exception.NotInDataBaseException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;


public class Application {
    private static final EntityManagerFactory maneger= Persistence.createEntityManagerFactory("Backend-W3.L2");




    public static void main(String[] args) throws NotInDataBaseException {

        EntityManager con=maneger.createEntityManager(); //responsabile dell'esecuzioni di operazioni con il database
        EventsDAO ev=new EventsDAO(con);
        LocationDAO loc=new LocationDAO(con);
        Location lo=new Location("Asfalto Nero","Venezia");
        AthleticCompetition atl=new AthleticCompetition(lo);
        AthleticCompetition at= new AthleticCompetition("Gara di triatlon","23-10-2024" ,530000, EventType.PRIVATO,lo);
        loc.save(lo);
        ev.save(at);
        con.close();
        maneger.close();
    }
}
