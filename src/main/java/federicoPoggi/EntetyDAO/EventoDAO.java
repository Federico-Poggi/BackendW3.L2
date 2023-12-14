package federicoPoggi.EntetyDAO;

import federicoPoggi.Enteties.EventType;
import federicoPoggi.Enteties.Evento;
import federicoPoggi.Enteties.Location;
import federicoPoggi.Exception.NotInDataBaseException;
import javax.persistence.*;
import java.util.Scanner;

public class EventoDAO {
    public final EntityManager con;
    public EventoDAO(EntityManager con){this.con=con;}


    public void save() throws NotInDataBaseException {
        Scanner scan=new Scanner(System.in);
        EntityTransaction transaction = con.getTransaction(); //avvio transazione
        transaction.begin();
        boolean finish=false;
        do{
            //inserimento dati dall'utente
            String yes="YES";
            String no="NO";
            Evento event= new Evento();
            Location locev= new Location("Padova Fiere","Padova");
            con.persist(locev);
            event.setLocation(locev);
            /*----------------------------------------------------*/
            System.out.println("Inserisci nome evento: ");
            event.setEvent_title(scan.nextLine());
            /*----------------------------------------------------*/
            System.out.println("Quando: ");
            event.setEvent_date(scan.nextLine());
            /*----------------------------------------------------*/
            System.out.println("Numero massimo di partecipanti: ");
            event.setNumber_participants_max(scan.nextInt());
            /*----------------------------------------------------*/
            System.out.println("Inserisci tipo evento: ");

            String tipo = scan.nextLine().toUpperCase();

            switch(tipo){
                case "PUBBLICO":
                    event.setType(EventType.PUBBLICO);
                case "PRIVATO":
                    event.setType(EventType.PRIVATO);
            }
            /*----------------------------------------------------*/
            con.persist(event);
            /*----------------------------------------------------*/
            System.out.println("Aggiungere altri eventi?");
            String userIn= scan.nextLine().toUpperCase();
            /*----------------------------------------------------*/
            if (userIn.compareTo(yes)==0){
                System.out.println(event.getEvent_title() +  " è stato Aggiunto alla lista");
                finish=true;
            }

            transaction.commit();
        }while(finish);

    };





    public Evento getById(long id_event){
        Evento getEv=con.find(Evento.class, id_event);
        return getEv;
    };




    public void delete(String eventTitle){
        Query queryDelete=con.createQuery("DELETE Evento WHERE event_title = :eventTitle");
        EntityTransaction ev= con.getTransaction();
        try{
            ev.begin();
            queryDelete.setParameter("eventTitle", eventTitle);
            int numeroEveEliminati= queryDelete.executeUpdate();
            System.out.println(numeroEveEliminati);
            if(numeroEveEliminati==0){
                System.out.println("Il nome"+" "+ "'"+eventTitle+"'" +" non esiste:\n -Terminare operazione (PRESS T)\n -Reinserire nome (PRESS R)");
            }
            ev.commit();
        }catch (Exception e){
            throw new RuntimeException("Non valido");
        }finally {
            con.close();
        }







    }






}
