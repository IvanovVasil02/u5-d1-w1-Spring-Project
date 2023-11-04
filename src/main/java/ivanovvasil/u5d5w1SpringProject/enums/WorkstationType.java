package ivanovvasil.u5d5w1SpringProject.enums;

import java.util.Random;

public enum WorkstationType {
  PRIVATE, OPENSPACE, METTING_ROOM;

  private static final Random rndm = new Random();

  public static WorkstationType getRandomWorkstationType() {
    WorkstationType[] workstations = values();
    return workstations[rndm.nextInt(workstations.length)];
  }
}
