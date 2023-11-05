package ivanovvasil.u5d5w1SpringProject.runners;

import com.github.javafaker.Faker;
import ivanovvasil.u5d5w1SpringProject.dao.prenotation.IPrenotationDAO;
import ivanovvasil.u5d5w1SpringProject.dao.user.IUsersDAO;
import ivanovvasil.u5d5w1SpringProject.dao.workstation.IWorkstationDAO;
import ivanovvasil.u5d5w1SpringProject.entities.Prenotation;
import ivanovvasil.u5d5w1SpringProject.entities.User;
import ivanovvasil.u5d5w1SpringProject.entities.Workstation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Component
@Order(4)
public class PrenotationRunner implements CommandLineRunner {
  @Autowired
  private IUsersDAO usersDAO;
  @Autowired
  private IWorkstationDAO workstationDAO;
  @Autowired
  private IPrenotationDAO prenotationDAO;

  @Override
  public void run(String... args) throws Exception {
    Faker faker = new Faker(Locale.ITALY);
    List<User> usersList = usersDAO.findAll();
    List<Workstation> workstationList = workstationDAO.findAll();
    SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");

    for (int i = 0; i < 10; i++) {
      User randomUser = usersList.get(faker.number().numberBetween(1, usersList.size() - 1));
      Workstation randomWorkstation = workstationList.get(faker.number().numberBetween(1, workstationList.size() - 1));
      Date randomDate = faker.date().between(formatter.parse("04-10-2023"), formatter.parse("12-12-2024"));
      Prenotation newPrenotation = new Prenotation(randomUser, randomWorkstation, formatter.format(randomDate));
      prenotationDAO.save(newPrenotation);
    }


  }
}
