package ivanovvasil.u5d5w1SpringProject.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder(builderClassName = "prenotationFromFaker")
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

  public void setUser(User user) {
    this.user = user;
  }

  public void setWorkstation(Workstation workstation) {
    this.workstation = workstation;
  }

  public void setDate(LocalDate date) {
    this.date = date;
  }

  public static class prenotationFromFaker {
    private LocalDate date = LocalDate.now();
  }
}
