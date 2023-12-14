package federicoPoggi.Enteties;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "concerts")
public class Concert extends Evento{
    public Concert(Location location) {
        super(location);
    }


}
