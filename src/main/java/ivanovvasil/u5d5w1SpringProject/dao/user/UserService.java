package ivanovvasil.u5d5w1SpringProject.dao.user;

import ivanovvasil.u5d5w1SpringProject.entities.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUsersDAO {
  @Override
  public void save(User user) {

  }

  @Override
  public void findByIdAndDelete(Long id) {

  }

  @Override
  public void findByIdAndUpdate(User user) {

  }

  @Override
  public User findById(Long id) {
    return null;
  }

  @Override
  public List<User> findAll() {
    return null;
  }
}
