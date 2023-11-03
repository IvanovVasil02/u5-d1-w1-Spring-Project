package ivanovvasil.u5d5w1SpringProject.dao.building;

import ivanovvasil.u5d5w1SpringProject.entities.Building;

import java.util.List;

public interface IBuildingDAO {
  public void save(Building user);

  public void findByIdAndDelete(Long id);

  public void findByIdAndUpdate(Building user);

  public Building findById(Long id);

  public List<Building> findAll();
}
