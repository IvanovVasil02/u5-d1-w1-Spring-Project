package ivanovvasil.u5d5w1SpringProject.entities;

import com.github.javafaker.Faker;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;
import java.util.Locale;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder(builderClassName = "buildingFromFaker")
@ToString
public class Building {
  @Id
  @GeneratedValue
  private long Id;
  private String buildingName;
  private String address;
  private String city;
  @OneToMany(mappedBy = "building")
  private List<Workstation> workstationList;

  public void setName(String name) {
    this.buildingName = name;
  }

  public void setAddress(String address) {
    this.address = address;

  }

  public void setCity(String city) {
    this.city = city;
  }

  public static class buildingFromFaker {
    Faker f = new Faker(Locale.ITALY);
    private String buildingName = f.company().name();
    private String address = f.address().streetAddress();
    private String city = f.address().city();
  }
}
