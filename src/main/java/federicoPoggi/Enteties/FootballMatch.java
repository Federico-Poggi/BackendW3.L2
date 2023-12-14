package federicoPoggi.Enteties;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "football_match")
public class FootballMatch extends Evento{
    @Column(name = "home_team")
    String homeTeam;
    @Column(name = "visiting_team")
    String visitingTeam;
    @Column(name = "winners", nullable = true)
    String winners;
    @Column(name = "goal_home_team")
    int goalHomeTeam;
    @Column(name = "goal_visiting_team")
    int goalVisitingTeam;


    public FootballMatch(Location location) {
        this.location=location;
    }

    public FootballMatch(String event_title, String event_date, int number_participants_max,
                         EventType eventYpe, String homeTeam, String visitingTeam, String winners,
                         int goalHomeTeam, int goalVisitingTeam)
    {
        this.event_title=event_title;
        this.event_date=event_date;
        this.number_participants_max=number_participants_max;
        this.type=eventYpe;
        this.homeTeam = homeTeam;
        this.visitingTeam = visitingTeam;
        this.winners = winners;
        this.goalHomeTeam = goalHomeTeam;
        this.goalVisitingTeam = goalVisitingTeam;
    }

    public FootballMatch(String event_title, String event_date, int number_participants_max, EventType eventYpe) {
        super(event_title,event_date,number_participants_max,eventYpe);
    }


    /*--GETTERS AND SETTERS--*/

    public String getHomeTeam() {

        return homeTeam;
    }

    public void setHomeTeam(String homeTeam) {
        this.homeTeam = homeTeam;
    }

    public String getVisitingTeam() {
        return visitingTeam;
    }

    public void setVisitingTeam(String visitingTeam) {
        this.visitingTeam = visitingTeam;
    }

    public String getWinners() {
        return winners;
    }

    public void setWinners(String winners) {
        this.winners = winners;
    }

    public int getGoalHomeTeam() {
        return goalHomeTeam;
    }

    public void setGoalHomeTeam(int goalHomeTeam) {
        this.goalHomeTeam = goalHomeTeam;
    }

    public int getGoalVisitingTeam() {
        return goalVisitingTeam;
    }

    public void setGoalVisitingTeam(int goalVisitingTeam) {
        this.goalVisitingTeam = goalVisitingTeam;
    }
}
