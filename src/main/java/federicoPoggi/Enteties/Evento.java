package federicoPoggi.Enteties;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity //Perche sara un'entita del database
@Table(name = "eventi")//nome tabella --> database

public class Evento {
@Id //chiave primari (Obbligatorio)
    private long event_id;
@Column(name = "event_title")
    private String event_title;
@Column(name = "event_date")
    private String event_date;
@Column(name = "number_max_participants")
    private int number_participants_max;

    public Evento (String event_title,String event_date,int number_participants_max){
        this.event_title=event_title;
        this.event_date=event_date;
        this.number_participants_max=number_participants_max;
    }

/*GETTERS AND SETTERS*/
    public long getEvent_id() {
        return event_id;
    }

    public void setEvent_id(long event_id) {
        this.event_id = event_id;
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
