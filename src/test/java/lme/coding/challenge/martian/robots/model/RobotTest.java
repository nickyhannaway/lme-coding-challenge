package lme.coding.challenge.martian.robots.model;

import static java.util.Arrays.asList;
import static lme.coding.challenge.martian.robots.model.CartesianCommand.Commands.F;
import static lme.coding.challenge.martian.robots.model.CartesianCommand.Commands.L;
import static lme.coding.challenge.martian.robots.model.CartesianCommand.Commands.R;
import static lme.coding.challenge.martian.robots.model.Orientations.S;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import lme.coding.challenge.martian.robots.model.CartesianCommand.Commands;
import org.junit.jupiter.api.Test;

public class RobotTest {

  @Test
  public void shouldConstructSuccessfully() {
    // given
    List<Commands> commands = asList(L, L, F, R, F, F, L);
    CartesianPosition position = CartesianPosition.builder().yCoord(1).yCoord(1).orientation(S)
        .build();

    // when
    Robot result = Robot.builder().commands(commands).currentPosition(position).build();

    // then
    assertNotNull(result);
    assertFalse(result.isLost());
  }

  @Test
  public void shouldExploreAndNotGetLost() {
    // given
    List<Commands> commands = asList(L, L, F, R, F, F, L);
    CartesianPosition position = CartesianPosition.builder().yCoord(1).yCoord(1).orientation(S)
        .build();
    CartesianLandscape landscape = CartesianLandscape.builder().xCoordBoundary(50)
        .yCoordBoundary(50).build();
    Robot robot = Robot.builder().commands(commands).currentPosition(position).build();

    // when
    robot.explore(landscape);

    // then
    assertFalse(robot.isLost());
    CartesianPosition finalPosition = (CartesianPosition) robot.getCurrentPosition();
    assertEquals(2, finalPosition.getXCoord());
    assertEquals(2, finalPosition.getYCoord());
  }

  @Test
  public void shouldExploreAndGetLost() {
    // given
    List<Commands> commands = asList(L, L, F, R, F, F, L, F, F, F);
    CartesianPosition position = CartesianPosition.builder().yCoord(1).yCoord(1).orientation(S)
        .build();
    CartesianLandscape landscape = CartesianLandscape.builder().xCoordBoundary(2)
        .yCoordBoundary(2).build();
    Robot robot = Robot.builder().commands(commands).currentPosition(position).build();

    // when
    robot.explore(landscape);

    // then
    assertTrue(robot.isLost());
    CartesianPosition finalPosition = (CartesianPosition) robot.getCurrentPosition();
    assertEquals(2, finalPosition.getXCoord());
    assertEquals(2, finalPosition.getYCoord());
  }
}
