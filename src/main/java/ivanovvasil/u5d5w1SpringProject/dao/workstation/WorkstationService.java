package ivanovvasil.u5d5w1SpringProject.dao.workstation;

import ivanovvasil.u5d5w1SpringProject.entities.Workstation;
import ivanovvasil.u5d5w1SpringProject.enums.WorkstationType;
import ivanovvasil.u5d5w1SpringProject.exceptions.ItemNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkstationService implements IWorkstationDAO {
  @Autowired
  private WorkstationRepository repository;

  @Override
  public void save(Workstation user) {
    repository.save(user);
  }

  @Override
  public List<Workstation> findAll() {
    return repository.findAll();
  }

  @Override
  public void findByTypeAndCity(WorkstationType type, String city) {
    List<Workstation> workstationList = repository.findByWorkstationTypeAndCity(type, city);

    if (!workstationList.isEmpty()) {
      workstationList.forEach(System.out::println);
    } else {
      System.out.println("We are sorry, we do not have any positions that reflect the parameters entered...");
      System.out.println("Here is a list of all our locations");
      this.showAllWorkstation();
    }

  }

  @Override
  public void showAllWorkstation() {
    repository.findAll().forEach(System.out::println);
  }

  @Override
  public Workstation findById(Long id) throws ItemNotFoundException {
    return repository.findById(id).orElseThrow(() -> new ItemNotFoundException(id));
  }

  @Override
  public void findByIdAndDelete(Long id) throws ItemNotFoundException {
    repository.delete(this.findById(id));
  }

  @Override
  public void findByIdAndUpdate(Workstation user) {

  }
}
