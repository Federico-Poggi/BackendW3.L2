package federicoPoggi.Enteties;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
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


    /*---COSTRUTTORI---*/
    public Person(){}
}
