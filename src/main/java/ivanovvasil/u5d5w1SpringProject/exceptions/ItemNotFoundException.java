package ivanovvasil.u5d5w1SpringProject.exceptions;

public class ItemNotFoundException extends RuntimeException {
  public ItemNotFoundException(long id) {
    super("The item whit id " + id + " was not found...");
  }

  public ItemNotFoundException() {
    super("Item not found...");
  }

  public ItemNotFoundException(String username) {
    super("There is no registered user with this username: " + username);
  }

}
