package ivanovvasil.u5d5w1SpringProject.dao.workstation;

import ivanovvasil.u5d5w1SpringProject.entities.Workstation;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkstationService implements IWorkstationDAO {
  @Override
  public void save(Workstation user) {

  }

  @Override
  public void findByIdAndDelete(Long id) {

  }

  @Override
  public void findByIdAndUpdate(Workstation user) {

  }

  @Override
  public Workstation findById(Long id) {
    return null;
  }

  @Override
  public List<Workstation> findAll() {
    return null;
  }
}
