package ivanovvasil.u5d5w1SpringProject.dao.building;

import ivanovvasil.u5d5w1SpringProject.entities.Building;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuildingRepository extends JpaRepository<Building, Long> {

}
