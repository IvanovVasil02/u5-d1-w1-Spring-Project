package ivanovvasil.u5d5w1SpringProject.runners;

import com.github.javafaker.Faker;
import ivanovvasil.u5d5w1SpringProject.dao.building.IBuildingDAO;
import ivanovvasil.u5d5w1SpringProject.dao.workstation.IWorkstationDAO;
import ivanovvasil.u5d5w1SpringProject.entities.Building;
import ivanovvasil.u5d5w1SpringProject.entities.Workstation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import java.util.List;
import java.util.Locale;

//@Component
//@Order(3)
public class WorkstationRunner implements CommandLineRunner {
  @Autowired
  private IWorkstationDAO workstationDAO;
  @Autowired
  private IBuildingDAO buildingDAO;

  @Override
  public void run(String... args) throws Exception {
    Faker faker = new Faker(Locale.ITALY);
    List<Building> buildingList = buildingDAO.findAll();
    for (int i = 0; i < 10; i++) {
      Building randomBuilding = buildingList.get(faker.number().numberBetween(1, buildingList.size() - 1));
      Workstation workstation = Workstation.builder().building(randomBuilding).build();
      workstationDAO.save(workstation);
    }

  }
}
