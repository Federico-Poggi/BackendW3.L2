package federicoPoggi.EntetyDAO;

import federicoPoggi.Enteties.Location;
import federicoPoggi.Exception.NotInDataBaseException;
import org.hibernate.Transaction;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;
import java.util.Scanner;

public class LocationDAO {
    public final EntityManager con;
    public LocationDAO(EntityManager con){this.con=con;}

    private String locationName;
    private Location location=new Location();
    public void save(Location loc){
        Scanner scan=new Scanner(System.in);
        EntityTransaction transaction=con.getTransaction();
        transaction.begin();

        con.persist(loc);

        transaction.commit();
    }


    public String getLocationName() {
        return locationName;
    }


    public Location getLocation() {
        return location;
    }


}
