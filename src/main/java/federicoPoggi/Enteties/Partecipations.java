package federicoPoggi.Enteties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "partecipations")
public class Partecipations {
    /*---ATTRIBUTI---*/

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long partecipation_id;
    @Column(name = "persona")
    private String persona;
    @Column(name = "state")
    @Enumerated(EnumType.STRING)
    Conferma state;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Evento evento;

    /*@ManyToMany(mappedBy = "partecipations_id")
    private List<Person> people=new ArrayList<>();*/


    /*---COSTRUTTORI---*/



}
