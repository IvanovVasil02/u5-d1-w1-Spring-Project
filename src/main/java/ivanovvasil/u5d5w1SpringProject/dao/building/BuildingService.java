package ivanovvasil.u5d5w1SpringProject.dao.building;

import ivanovvasil.u5d5w1SpringProject.entities.Building;
import ivanovvasil.u5d5w1SpringProject.exceptions.ItemNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuildingService implements IBuildingDAO {
  private BuildingRepository repository;

  @Override
  public void save(Building user) {
    repository.save(user);
  }

  @Override
  public List<Building> findAll() {
    return repository.findAll();
  }

  @Override
  public Building findById(Long id) throws ItemNotFoundException {
    return repository.findById(id).orElseThrow(() -> new ItemNotFoundException(id));
  }

  @Override
  public void findByIdAndDelete(Long id) throws ItemNotFoundException {

    repository.delete(this.findById(id));
  }

  @Override
  public void findByIdAndUpdate(Building user) {
  }


}
