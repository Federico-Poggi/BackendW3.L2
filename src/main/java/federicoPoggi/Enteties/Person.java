package federicoPoggi.Enteties;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "persone")
public class Person {
    /*--ATTRIBUTI--*/

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long person_id;

    @Column(name = "first_name")
    private String first_name;

    @Column(name = "last_name")
    private String last_name;

    @Column(name = "person_email")
    private String person_email;

    @Column(name = "birthday")
    private LocalDate birthday;

    @Column(name = "genres")
    private char Genre;

   @ManyToMany
   @JoinTable(
           name = "person_partecipation",
           joinColumns = @JoinColumn(name = "person_id"),
           inverseJoinColumns = @JoinColumn(name = "partecipation_id")
   )
   private List<Partecipations> partecipations=new ArrayList<>();

    /*---COSTRUTTORI---*/
    public Person(){}
}
