package ivanovvasil.u5d5w1SpringProject.dao.prenotation;

import ivanovvasil.u5d5w1SpringProject.entities.Prenotation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface PrenotationRepository extends JpaRepository<Prenotation, Long> {
  @Query("SELECT p.date FROM Prenotation p")
  List<LocalDate> getAllPrenotatedDay();

}
