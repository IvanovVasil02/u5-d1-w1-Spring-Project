package ivanovvasil.u5d5w1SpringProject.dao.prenotation;

import ivanovvasil.u5d5w1SpringProject.entities.Prenotation;
import ivanovvasil.u5d5w1SpringProject.exceptions.ItemNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrenotationService implements IPrenotationDAO {
  private PrenotationRepository repository;

  @Override
  public void save(Prenotation user) {

    repository.save(user);
  }

  @Override
  public List<Prenotation> findAll() {
    return repository.findAll();
  }

  @Override
  public Prenotation findById(Long id) throws ItemNotFoundException {
    return repository.findById(id).orElseThrow(() -> new ItemNotFoundException(id));
  }


  @Override
  public void findByIdAndDelete(Long id) throws ItemNotFoundException {
    repository.delete(this.findById(id));
  }

  @Override
  public void findByIdAndUpdate(Prenotation user) {

  }

}
