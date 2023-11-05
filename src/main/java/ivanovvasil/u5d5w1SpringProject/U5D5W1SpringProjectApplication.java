package ivanovvasil.u5d5w1SpringProject;

import ivanovvasil.u5d5w1SpringProject.dao.prenotation.IPrenotationDAO;
import ivanovvasil.u5d5w1SpringProject.dao.user.IUsersDAO;
import ivanovvasil.u5d5w1SpringProject.dao.workstation.IWorkstationDAO;
import ivanovvasil.u5d5w1SpringProject.entities.Prenotation;
import ivanovvasil.u5d5w1SpringProject.entities.User;
import ivanovvasil.u5d5w1SpringProject.entities.Workstation;
import ivanovvasil.u5d5w1SpringProject.enums.WorkstationType;
import ivanovvasil.u5d5w1SpringProject.exceptions.EmptyListException;
import ivanovvasil.u5d5w1SpringProject.exceptions.ItemNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.SimpleDateFormat;
import java.util.Scanner;

@SpringBootApplication
public class U5D5W1SpringProjectApplication {
  private static IUsersDAO usersDAO;
  private static IWorkstationDAO workstationDAO;
  private static IPrenotationDAO prenotationDAO;

  public static void main(String[] args) {
    SpringApplication.run(U5D5W1SpringProjectApplication.class, args);
    SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
    boolean active = true;

    try {
      while (active) {
        try {
          Scanner scanner = new Scanner(System.in);
          System.out.println("0: Esc\n1: Book a workstation\n2: Search a workstation");
          int choiceMenu = Integer.parseInt(scanner.nextLine());
          switch (choiceMenu) {
            case 0: {
              System.out.println("You chose to leave");
              active = false;
              break;
            }
            case 1: {
              System.out.println("You chose to book a workstation");
              System.out.println("Are you already registered?\n1: yes\n2: Do it\n0: Esc");
              int choiceUser = Integer.parseInt(scanner.nextLine());
              switch (choiceUser) {
                case 0: {
                  System.out.println("You chose to leave");
                  break;
                }

                case 1: {
                  System.out.println("Enter your username");
                  String username = scanner.nextLine();
                  User user = usersDAO.findByUsername(username);

                  workstationDAO.showAllWorkstation();
                  System.out.println("Enter an id of the workstation you want to reserve");
                  Long workstationId = Long.valueOf(scanner.nextLine());
                  Workstation workstation = workstationDAO.findById(workstationId);

                  System.out.println("Enter the date you want to book (dd-MM-yyyy)");
                  String userDate = scanner.nextLine();

                  Prenotation newPrenotation = new Prenotation(user, workstation, userDate);
                  prenotationDAO.save(newPrenotation);
                  System.out.println("booking successful");
                  break;
                }
                case 2: {
                  System.out.println("Enter the username you want to use:");
                  String username = scanner.nextLine();

                  System.out.println("Enter your full name:");
                  String fullName = scanner.nextLine();

                  System.out.println("Enter your email:");
                  String email = scanner.nextLine();

                  User newUser = User.builder().username(username).fullName(fullName).email(email).build();
                  usersDAO.save(newUser);

                  System.out.println("Registration was successful");

                  workstationDAO.showAllWorkstation();
                  System.out.println("Enter an id of the workstation you want to reserve");
                  Long workstationId = Long.valueOf(scanner.nextLine());
                  Workstation workstation = workstationDAO.findById(workstationId);

                  System.out.println("Enter the date you want to book (dd-MM-yyyy)");
                  String userDate = scanner.nextLine();

                  Prenotation newPrenotation = new Prenotation(newUser, workstation, formatter.format(formatter.parse(userDate)));
                  prenotationDAO.save(newPrenotation);
                  System.out.println("booking successful");
                  break;
                }

              }

              break;
            }
            case 2: {
              System.out.println("you have chosen to look for a workstation");

              System.out.println("What type of workstation are you looking for?\n1: PRIVATE\n2: OPENSPACE\n3: METTING_ROOM");
              int chosenWorkstation = Integer.parseInt(scanner.nextLine());
              WorkstationType workstationType = WorkstationType.getMeWorkstationType(chosenWorkstation);

              System.out.println("Enter the name of the city in which you are trying to book a workstation");
              String city = scanner.nextLine();
              workstationDAO.findByTypeAndCity(workstationType, city);
              break;
            }

          }
        } catch (ItemNotFoundException | EmptyListException e) {
          System.out.println(e.getMessage());
        } catch (ArrayIndexOutOfBoundsException e) {
          System.out.println("You have to enter an id of the list");
        } catch (java.time.format.DateTimeParseException e) {
          System.out.println("You did not enter the correct date format");
        } catch (Exception e) {
          throw new RuntimeException(e);
        }
      }
    } catch (ItemNotFoundException | EmptyListException e) {
      System.out.println(e.getMessage());
    } catch (Exception e) {
      throw new RuntimeException(e);
    }

  }

  @Autowired
  public void MainApplication(IUsersDAO usersDAO, IWorkstationDAO workstationDAO, IPrenotationDAO prenotationDAO) {
    this.usersDAO = usersDAO;
    this.workstationDAO = workstationDAO;
    this.prenotationDAO = prenotationDAO;
  }

}
