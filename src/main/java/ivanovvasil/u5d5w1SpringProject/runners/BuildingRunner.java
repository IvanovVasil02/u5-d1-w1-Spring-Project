package ivanovvasil.u5d5w1SpringProject.runners;

import ivanovvasil.u5d5w1SpringProject.dao.building.IBuildingDAO;
import ivanovvasil.u5d5w1SpringProject.entities.Building;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(2)
public class BuildingRunner implements CommandLineRunner {
  @Autowired
  private IBuildingDAO buildingDAO;

  @Override
  public void run(String... args) throws Exception {
    Building newBuilding = Building.builder().build();
    buildingDAO.save(newBuilding);
    for (int i = 0; i < 10; i++) {
      buildingDAO.save(newBuilding);
    }
  }
}
