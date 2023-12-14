package federicoPoggi.Enteties;

import org.hibernate.annotations.JoinColumnOrFormula;

import javax.persistence.*;

@Entity
@Table(name = "concerts")
public class Concert extends Evento{

@Column(name = "genere")
@Enumerated(EnumType.STRING)
private MusicGen genere;

@Column(name = "streaming", nullable = false)
boolean streaming;
    public Concert(Location location) {
        this.location=location;
    }

    public Concert(String eventTitle, String eventDate, int numberParticipantsMax,
                   EventType eventYpe,MusicGen gen, boolean streaming) {
        super(eventTitle, eventDate, numberParticipantsMax, eventYpe);
        this.genere=gen;
        this.streaming=streaming;
    }

    public Concert() {
    }


    /*---GETTERS AND SETTER---*/

    public MusicGen getGenere() {
        return genere;
    }

    public void setGenere(MusicGen genere) {
        this.genere = genere;
    }

    public boolean isStreaming() {
        return streaming;
    }

    public void setStreaming(boolean streaming) {
        this.streaming = streaming;
    }
}
