package ivanovvasil.u5d5w1SpringProject.dao.user;

import ivanovvasil.u5d5w1SpringProject.entities.User;

import java.util.List;

public interface IUsersDAO {
  public void save(User user);

  public void findByIdAndDelete(Long id);

  public void findByIdAndUpdate(User user);

  public User findById(Long id);

  public List<User> findAll();
}
