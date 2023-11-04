package ivanovvasil.u5d5w1SpringProject.entities;

import com.github.javafaker.Faker;
import ivanovvasil.u5d5w1SpringProject.enums.WorkstationType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;
import java.util.Locale;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder(builderClassName = "workstationFromfaker")
@ToString
public class Workstation {
  @Id
  @GeneratedValue
  private long Id;
  private String description;
  private WorkstationType type;
  private int maxOccupants;
  @ManyToOne
  @JoinColumn(name = "building_id")
  private Building building;
  @OneToMany(mappedBy = "workstation")
  private List<Prenotation> prenotationList;

  public void setDescription(String description) {
    this.description = description;
  }

  public void setType(WorkstationType type) {
    this.type = type;
  }

  public static class workstationFromfaker {
    Faker f = new Faker(Locale.ITALY);
    private String description = "Description....";
    private WorkstationType type = WorkstationType.OPENSPACE;
    private int maxOccupants = f.number().numberBetween(4, 10);
  }
}
