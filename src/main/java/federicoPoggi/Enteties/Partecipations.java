package federicoPoggi.Enteties;

import javax.persistence.*;

@Entity
@Table(name = "partecipations")
public class Partecipations {
    /*---ATTRIBUTI---*/

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long partecipation_id;
    @Column(name = "persona")
    private String persona;
    @Column(name = "evento")
    private String evento;

    @Column(name = "stao")
    @Enumerated(EnumType.STRING)
    Conferma state;

    /*---COSTRUTTORI---*/



}
