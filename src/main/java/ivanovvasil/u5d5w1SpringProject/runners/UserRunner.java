package ivanovvasil.u5d5w1SpringProject.runners;

import ivanovvasil.u5d5w1SpringProject.dao.user.IUsersDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class UserRunner implements CommandLineRunner {
  @Autowired
  private IUsersDAO usersDAO;

  @Override
  public void run(String... args) throws Exception {
//    for (int i = 0; i < 10; i++) {
//      User newUser = User.builder().build();
//      usersDAO.save(newUser);
//    }

  }
}
