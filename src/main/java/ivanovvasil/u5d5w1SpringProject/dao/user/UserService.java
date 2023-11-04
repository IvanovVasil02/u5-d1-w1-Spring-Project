package ivanovvasil.u5d5w1SpringProject.dao.user;

import ivanovvasil.u5d5w1SpringProject.entities.User;
import ivanovvasil.u5d5w1SpringProject.exceptions.ItemNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUsersDAO {
  @Autowired
  private UserRepository repository;

  @Override
  public void save(User user) {
    repository.save(user);
  }

  @Override
  public List<User> findAll() {
    return repository.findAll();
  }

  @Override
  public User findById(Long id) throws ItemNotFoundException {
    return repository.findById(id).orElseThrow(() -> new ItemNotFoundException(id));
  }

  @Override
  public void findByIdAndDelete(Long id) throws ItemNotFoundException {
    repository.delete(this.findById(id));

  }

  @Override
  public void findByIdAndUpdate(User user) {

  }

}
