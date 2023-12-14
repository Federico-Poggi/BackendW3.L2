package federicoPoggi.Enteties;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity //Perche sara un'entita del database
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@DiscriminatorColumn(name="tipo_evento")

public class Evento {

    /*ATTRIBUTI*/

@Id //chiave primaria (Obbligatorio)
@GeneratedValue
    private long event_id;
@Column(name = "event_title")
    protected String event_title;
@Column(name = "event_date")
    protected String event_date;
@Column(name = "number_max_participants")
    protected int number_participants_max;
@Column(name = "tipo_evento")
@Enumerated(EnumType.STRING)
protected EventType type;

@OneToMany(mappedBy = "partecipation_id")//perche un evento puo avere tante partecipazioni
protected List<Partecipations> partecipations=new ArrayList<>();

@ManyToOne
@JoinColumn(name = "id_location")
protected Location location;

    public Evento(Location location) {
        this.location=location;
    }

    public Evento(String eventTitle, String eventDate, int numberParticipantsMax, EventType eventYpe) {
        this.event_title=eventTitle;
        this.event_date=eventDate;
        this.number_participants_max=numberParticipantsMax;
        this.type=eventYpe;
    }

    public Evento() {
        
    }

    /*GETTERS AND SETTERS*/

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public long getEvent_id() {
        return event_id;
    }

    public String getEvent_title() {
        return event_title;
    }

    public void setEvent_title(String event_title) {
        this.event_title = event_title;
    }

    public String getEvent_date() {
        return event_date;
    }

    public void setEvent_date(String event_date) {
        this.event_date = event_date;
    }

    public int getNumber_participants_max() {
        return number_participants_max;
    }

    public EventType getType() {
        return type;
    }

    public void setType(EventType type) {
        this.type = type;
    }

    public void setNumber_participants_max(int number_participants_max) {
        this.number_participants_max = number_participants_max;
    }

    @Override
    public String toString() {
        return "evento: " + getEvent_title();
    }

}
