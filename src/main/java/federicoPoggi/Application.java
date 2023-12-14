package federicoPoggi;
import federicoPoggi.Enteties.*;
import federicoPoggi.EntetyDAO.*;
import federicoPoggi.Exception.NotInDataBaseException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;



public class Application {
    private static final EntityManagerFactory maneger= Persistence.createEntityManagerFactory("Backend-W3.L2");




    public static void main(String[] args) throws NotInDataBaseException {

        EntityManager con=maneger.createEntityManager(); //responsabile dell'esecuzioni di operazioni con il database
        EventoDAO ev=new EventoDAO(con);
        FootballMatch footballMatch=new FootballMatch("Inter-Milan", "21-07-24", 500000, EventType.PUBBLICO);
        /*Concert concert= new Concert("Concerto Memorial Freddy Marcury", "21-07-24", 500000,
                                        EventType.PUBBLICO, MusicGen.ROCK,true);
        Location location=new Location("San Siro","Milano");*/

        ev.delete("Concerto Memorial Freddy Marcury");
        con.close();
        maneger.close();
    }
}
