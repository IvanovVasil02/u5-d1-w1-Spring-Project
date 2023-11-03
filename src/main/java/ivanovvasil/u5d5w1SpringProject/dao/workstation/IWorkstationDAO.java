package ivanovvasil.u5d5w1SpringProject.dao.workstation;

import ivanovvasil.u5d5w1SpringProject.entities.Workstation;

import java.util.List;

public interface IWorkstationDAO {
  public void save(Workstation user);

  public void findByIdAndDelete(Long id);

  public void findByIdAndUpdate(Workstation user);

  public Workstation findById(Long id);

  public List<Workstation> findAll();
}
