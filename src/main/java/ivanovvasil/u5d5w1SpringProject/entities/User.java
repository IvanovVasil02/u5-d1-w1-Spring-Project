package ivanovvasil.u5d5w1SpringProject.entities;

import com.github.javafaker.Faker;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.List;
import java.util.Locale;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder(builderClassName = "userBuilderFromFaker")
@ToString
public class User {
  @Id
  @GeneratedValue
  private long id;
  private String username;
  private String fullName;
  private String email;
  @OneToMany(mappedBy = "user")
  private List<Prenotation> prenotationList;

  public void setUsername(String username) {
    this.username = username;
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public static class userBuilderFromFaker {
    private Faker f = new Faker(Locale.ITALY);
    private String username = f.name().username();
    private String fullName = f.name().fullName();
    private String email = f.internet().emailAddress();
  }
}
