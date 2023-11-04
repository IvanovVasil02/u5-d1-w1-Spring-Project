package ivanovvasil.u5d5w1SpringProject.exceptions;

import ivanovvasil.u5d5w1SpringProject.enums.WorkstationType;

public class EmptyListException extends RuntimeException {
  public EmptyListException(WorkstationType type, String city) {
    super("We're sorry but we can't find a " + type + " location of this type in " + city + "...");
  }

  public EmptyListException() {
    super("We're sorry but we cant'find any items...");
  }
}
