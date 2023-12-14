package federicoPoggi.EntetyDAO;

import federicoPoggi.Enteties.Location;
import federicoPoggi.Exception.NotInDataBaseException;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
import java.util.Scanner;

public class LocationDAO {
    public final EntityManager con;
    public LocationDAO(EntityManager con){this.con=con;}

    private String locationName;
    private Location location=new Location();
    public void save(){
        Scanner scan=new Scanner(System.in);
        System.out.println("Inserisci nome location evento: ");
        location.setName(scan.nextLine());
        System.out.println("Inserisci città evento: ");
        location.setCity(scan.nextLine());
        con.persist(location);
    }


    public String getLocationName() {
        return locationName;
    }


    public Location getLocation() {
        return location;
    }


}
