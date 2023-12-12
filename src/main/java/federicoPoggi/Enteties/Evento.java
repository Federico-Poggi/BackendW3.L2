package federicoPoggi.Enteties;


import javax.persistence.*;

@Entity //Perche sara un'entita del database
@Table(name = "eventi")//nome tabella --> database

public class Evento {

    /*ATTRIBUTI*/

@Id //chiave primaria (Obbligatorio)
@GeneratedValue
    private long event_id;
@Column(name = "event_title")
    private String event_title;
@Column(name = "event_date")
    private String event_date;
@Column(name = "number_max_participants")
    private int number_participants_max;
@Column(name = "tipo_evento")
@Enumerated(EnumType.STRING)
private EventType type;

public Evento(){};
public Evento (String event_title,String event_date,int number_participants_max, EventType eventYpe){
        this.event_title=event_title;
        this.event_date=event_date;
        this.type= eventYpe;
        this.number_participants_max=number_participants_max;
    }



    /*GETTERS AND SETTERS*/

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

    public void setNumber_participants_max(int number_participants_max) {
        this.number_participants_max = number_participants_max;
    }
}
