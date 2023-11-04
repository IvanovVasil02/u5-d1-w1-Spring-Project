package ivanovvasil.u5d5w1SpringProject.runners;

import ivanovvasil.u5d5w1SpringProject.dao.user.IUsersDAO;
import ivanovvasil.u5d5w1SpringProject.entities.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class UserRunner implements CommandLineRunner {
  private IUsersDAO usersDAO;

  @Override
  public void run(String... args) throws Exception {
    User newUser = User.builder().build();
    for (int i = 0; i < 10; i++) {
      usersDAO.save(newUser);
    }

  }
}
