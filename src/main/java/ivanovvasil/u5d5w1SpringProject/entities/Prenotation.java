package ivanovvasil.u5d5w1SpringProject.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Entity
@NoArgsConstructor
@Getter
@ToString
public class Prenotation {
  @Id
  @GeneratedValue
  private long id;
  @ManyToOne
  @JoinColumn(name = "user_id")
  private User user;
  @ManyToOne
  @JoinColumn(name = "workstation_id")
  private Workstation workstation;
  private LocalDate date;

  public Prenotation(User user, Workstation workstation, String date) {
    this.user = user;
    this.workstation = workstation;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    this.date = LocalDate.parse(date, formatter);
  }

  public void setUser(User user) {
    this.user = user;
  }

  public void setWorkstation(Workstation workstation) {
    this.workstation = workstation;
  }

  public void setDate(LocalDate date) {
    this.date = date;
  }

}
