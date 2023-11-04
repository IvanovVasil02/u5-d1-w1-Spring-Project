package ivanovvasil.u5d5w1SpringProject.dao.prenotation;

import ivanovvasil.u5d5w1SpringProject.entities.Prenotation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface PrenotationRepository extends JpaRepository<Prenotation, Long> {

  Boolean existsPrenotationByDate(LocalDate date);


}
