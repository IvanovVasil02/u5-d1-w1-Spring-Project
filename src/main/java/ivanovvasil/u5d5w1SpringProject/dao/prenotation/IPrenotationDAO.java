package ivanovvasil.u5d5w1SpringProject.dao.prenotation;

import ivanovvasil.u5d5w1SpringProject.entities.Prenotation;

import java.util.List;

public interface IPrenotationDAO {
  public void save(Prenotation user);

  public void findByIdAndDelete(Long id);

  public void findByIdAndUpdate(Prenotation user);

  public Prenotation findById(Long id);

  public List<Prenotation> findAll();
  
}
