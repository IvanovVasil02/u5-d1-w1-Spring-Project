package ivanovvasil.u5d5w1SpringProject.entities;

import com.github.javafaker.Faker;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Locale;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder(builderClassName = "buildingFromFaker")
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

  @Override
  public String toString() {
    return "Building{" +
            "Id=" + Id +
            ", buildingName='" + buildingName + '\'' +
            ", address='" + address + '\'' +
            ", city='" + city + '\'' +
            '}';
  }

  public static class buildingFromFaker {
    Faker f = new Faker(Locale.ITALY);
    private String buildingName = f.company().name();
    private String address = f.address().streetAddress();
    private String city = f.address().city();
  }
}
