package federicoPoggi.Enteties;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "concerts")
public class Concert extends Events {

@Column(name = "genere")
@Enumerated(EnumType.STRING)
private MusicGen genere;

@Column(name = "streaming", nullable = false)
boolean streaming;
    public Concert(Location location) {
        this.location=location;
    }

    public Concert(String eventTitle, String eventDate, int numberParticipantsMax,
                   EventType eventType, MusicGen gen, boolean streaming) {
        super(eventTitle, eventDate, numberParticipantsMax, eventType);
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
