package lme.coding.challenge.martian.robots.output;

import java.util.List;
import lme.coding.challenge.martian.robots.model.CartesianPosition;
import lme.coding.challenge.martian.robots.model.Robot;

public class OutputPrinter {

  public static void printRobotFinalPositions(List<Robot> robots) {
    System.out.println("\n*** Mars Exploration Results ***\n");
    robots.forEach(x -> printRobotData(x));
  }

  private static void printRobotData(Robot robot) {
    CartesianPosition finalPosition = (CartesianPosition) robot.getCurrentPosition();
    String lost = robot.isLost() ? "LOST" : "";
    System.out.println(String
        .format("%s%s %s %s", finalPosition.getXCoord(), finalPosition.getYCoord(),
            finalPosition.getOrientation(), lost));
  }
}
