package ivanovvasil.u5d5w1SpringProject.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
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
  private Date date;

  public void setUser(User user) {
    this.user = user;
  }

  public void setWorkstation(Workstation workstation) {
    this.workstation = workstation;
  }

  public void setDate(Date date) {
    this.date = date;
  }

}
