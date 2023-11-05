package ivanovvasil.u5d5w1SpringProject.dao.user;

import ivanovvasil.u5d5w1SpringProject.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

  User findDistinctUserByUsername(String username);
}
