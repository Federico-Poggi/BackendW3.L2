package federicoPoggi.Enteties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "location")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_location;

    @Column(name = "name")
    private String name;
    @Column(name = "city")
    private String city;

    @OneToMany(mappedBy = "event_id")
    private List<Evento> evento=new ArrayList<>();

    /*---COSTRUTTORI---*/
    public Location(){}
    public Location(String location_name,String citta){
        this.name=location_name;
        this.city=citta;
    }

    /*--GETTERS & SETTERS---*/

    public long getId_location() {
        return id_location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
