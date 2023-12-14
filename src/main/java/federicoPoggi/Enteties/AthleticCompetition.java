package federicoPoggi.Enteties;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.*;

@Entity
@Table(name = "athletic_competitions")
public class AthleticCompetition extends Events {
    @OneToMany(mappedBy = "person_id")
    List<Person> personList=new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "winner_id")
    private Person winner;


    public AthleticCompetition(Location location) {
        super(location);
    }

    public AthleticCompetition(String eventTitle, String eventDate,
                               int numberParticipantsMax, EventType eventYpe, Location location) {
        super(eventTitle, eventDate, numberParticipantsMax, eventYpe);
        this.location=location;

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
