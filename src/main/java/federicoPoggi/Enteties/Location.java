package federicoPoggi.Enteties;

import javax.persistence.*;
import java.security.PublicKey;

@Embeddable //non entity perche i cambi sono definiti dentro Event
@Table(name = "location")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_location;
    @Column(name = "nome")
    private String name;
    @Column(name = "citta")
    private String city;

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
