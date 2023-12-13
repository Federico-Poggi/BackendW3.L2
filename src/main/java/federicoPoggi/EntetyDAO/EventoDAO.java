package federicoPoggi.EntetyDAO;

import federicoPoggi.Enteties.Evento;



import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class EventoDAO {


    public final EntityManager con;
    public EventoDAO(EntityManager con){this.con=con;}

    public void save(Evento event){
       EntityTransaction transaction = con.getTransaction(); //avvio transazione

        transaction.begin();

        con.persist(event);

        transaction.commit();

        System.out.println(event.getEvent_title() +  " è stato Aggiunto alla lista");
    };

    public Evento getById(long id_event){
        Evento getEv=con.find(Evento.class, id_event);
        return getEv;
    };

    public void delete(Evento event){
        List<Evento> eventFind=this.getEventByName(event);
        EntityTransaction ev= con.getTransaction();

        if (!eventFind.isEmpty()){
            ev.begin();

            Evento e = getById(event.getEvent_id());

            con.remove(e);

            ev.commit();
        }else{
            System.out.println("Evento non trovato o gia cancellato");
        }

    }


    public String getNameByName(Evento evento){
        EntityTransaction ev= con.getTransaction();
        ev.begin();
        CriteriaBuilder criteriaBuilder=con.getCriteriaBuilder();
        CriteriaQuery<Evento> criteriaQuery=criteriaBuilder.createQuery(Evento.class);

        Root<Evento> eventoRoot= criteriaQuery.from(Evento.class);

        criteriaQuery.select(eventoRoot.get("event_title"));
        CriteriaQuery<Evento> select=criteriaQuery.select(eventoRoot);

        TypedQuery<Evento> query=con.createQuery(select);

        return evento.getEvent_title();
    }
    public List<Evento> getEventByName(String eventTitle){
        EntityTransaction ev= con.getTransaction();
        ev.begin();
        CriteriaBuilder criteriaBuilder=con.getCriteriaBuilder();
        CriteriaQuery<Evento> criteriaQuery=criteriaBuilder.createQuery(Evento.class);

        Root<Evento> eventoRoot= criteriaQuery.from(Evento.class);

        criteriaQuery.select(eventoRoot.get("event_title")).equals(eventTitle);
        CriteriaQuery<Evento> select=criteriaQuery.select(eventoRoot);

        TypedQuery<Evento> query=con.createQuery(select);
        return query.getResultList();
    }


}
