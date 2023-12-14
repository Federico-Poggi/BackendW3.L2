package federicoPoggi.Enteties;

import org.hibernate.annotations.JoinColumnOrFormula;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "athletic_competitions")
public class AthleticCompetition extends Evento {
    @OneToMany(mappedBy = "person_id")
    List<Person> personList=new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "winner_id")
    private Person winner;


    public AthleticCompetition(Location location){
        this.location=location;
    }

    public AthleticCompetition(String eventTitle, String eventDate, int numberParticipantsMax, EventType eventYpe) {
        super(eventTitle, eventDate, numberParticipantsMax, eventYpe);

    }

    public AthleticCompetition() {
    }

    /*----GETTERS AND SETTERS----*/

    public List<Person> getPersonList() {
        return personList;
    }

    public void setPersonList(List<Person> personList) {
        this.personList = personList;
    }

    public Person getWinner() {
        return winner;
    }

    public void setWinner(Person winner) {
        this.winner = winner;
    }
}
