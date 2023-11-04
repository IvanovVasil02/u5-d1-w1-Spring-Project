package ivanovvasil.u5d5w1SpringProject.dao.workstation;

import ivanovvasil.u5d5w1SpringProject.entities.Workstation;
import ivanovvasil.u5d5w1SpringProject.enums.WorkstationType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface WorkstationRepository extends JpaRepository<Workstation, Long> {
  @Query("SELECT w FROM Workstation w WHERE w.type = :type AND w.building.city LIKE :city%")
  List<Workstation> findByWorkstationTypeAndCity(@Param("type") WorkstationType type, @Param("city") String city);

}
