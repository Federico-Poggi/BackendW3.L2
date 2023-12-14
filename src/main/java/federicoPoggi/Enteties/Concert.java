package federicoPoggi.Enteties;

import org.hibernate.annotations.JoinColumnOrFormula;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "concerts")
public class Concert extends Evento{

@Column(name = "genere")
private MusicGen genere;

@Column(name = "streaming", nullable = false)
boolean streaming;
    public Concert(Location location) {
        super(location);
    }

    public Concert(String eventTitle, String eventDate, int numberParticipantsMax, EventType eventYpe) {
        super(eventTitle, eventDate, numberParticipantsMax, eventYpe);
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
