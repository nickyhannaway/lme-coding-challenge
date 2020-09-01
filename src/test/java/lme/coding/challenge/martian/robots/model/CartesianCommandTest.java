package lme.coding.challenge.martian.robots.model;

import static lme.coding.challenge.martian.robots.model.CartesianCommand.Commands.F;
import static lme.coding.challenge.martian.robots.model.CartesianCommand.Commands.L;
import static lme.coding.challenge.martian.robots.model.CartesianCommand.Commands.R;
import static lme.coding.challenge.martian.robots.model.Orientations.E;
import static lme.coding.challenge.martian.robots.model.Orientations.N;
import static lme.coding.challenge.martian.robots.model.Orientations.S;
import static lme.coding.challenge.martian.robots.model.Orientations.W;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class CartesianCommandTest {

  @Test
  public void shouldExecuteOnSuccessfullyInNorthFacingTurnRightScenario() {
    // given
    CartesianPosition position = CartesianPosition.builder().orientation(N).xCoord(1).yCoord(1)
        .build();
    CartesianCommand underTest = CartesianCommand.builder().command(R).build();

    // when
    CartesianPosition result = (CartesianPosition) underTest.executeOn(position);

    // then
    assertNotNull(result);
    assertTrue(result.getOrientation().equals(E));
    assertEquals(position.getXCoord(), result.getXCoord());
    assertEquals(position.getYCoord(), result.getYCoord());
  }

  @Test
  public void shouldExecuteOnSuccessfullyInNorthFacingTurnLeftScenario() {
    // given
    CartesianPosition position = CartesianPosition.builder().orientation(N).xCoord(1).yCoord(1)
        .build();
    CartesianCommand underTest = CartesianCommand.builder().command(L).build();

    // when
    CartesianPosition result = (CartesianPosition) underTest.executeOn(position);

    // then
    assertNotNull(result);
    assertTrue(result.getOrientation().equals(W));
    assertEquals(position.getXCoord(), result.getXCoord());
    assertEquals(position.getYCoord(), result.getYCoord());
  }

  @Test
  public void shouldExecuteOnSuccessfullyInNorthFacingGoForwardScenario() {
    // given
    CartesianPosition position = CartesianPosition.builder().orientation(N).xCoord(1).yCoord(1)
        .build();
    CartesianCommand underTest = CartesianCommand.builder().command(F).build();

    // when
    CartesianPosition result = (CartesianPosition) underTest.executeOn(position);

    // then
    assertNotNull(result);
    assertTrue(result.getOrientation().equals(N));
    assertEquals(position.getXCoord(), result.getXCoord());
    assertEquals(position.getYCoord() + 1, result.getYCoord());
  }

  @Test
  public void shouldExecuteOnSuccessfullyInSouthFacingTurnRightScenario() {
    // given
    CartesianPosition position = CartesianPosition.builder().orientation(S).xCoord(1).yCoord(1)
        .build();
    CartesianCommand underTest = CartesianCommand.builder().command(R).build();

    // when
    CartesianPosition result = (CartesianPosition) underTest.executeOn(position);

    // then
    assertNotNull(result);
    assertTrue(result.getOrientation().equals(W));
    assertEquals(position.getXCoord(), result.getXCoord());
    assertEquals(position.getYCoord(), result.getYCoord());
  }

  @Test
  public void shouldExecuteOnSuccessfullyInSouthFacingTurnLeftScenario() {
    // given
    CartesianPosition position = CartesianPosition.builder().orientation(S).xCoord(1).yCoord(1)
        .build();
    CartesianCommand underTest = CartesianCommand.builder().command(L).build();

    // when
    CartesianPosition result = (CartesianPosition) underTest.executeOn(position);

    // then
    assertNotNull(result);
    assertTrue(result.getOrientation().equals(E));
    assertEquals(position.getXCoord(), result.getXCoord());
    assertEquals(position.getYCoord(), result.getYCoord());
  }

  @Test
  public void shouldExecuteOnSuccessfullyInSouthFacingGoForwardScenario() {
    // given
    CartesianPosition position = CartesianPosition.builder().orientation(S).xCoord(1).yCoord(1)
        .build();
    CartesianCommand underTest = CartesianCommand.builder().command(F).build();

    // when
    CartesianPosition result = (CartesianPosition) underTest.executeOn(position);

    // then
    assertNotNull(result);
    assertTrue(result.getOrientation().equals(S));
    assertEquals(position.getXCoord(), result.getXCoord());
    assertEquals(position.getYCoord() - 1, result.getYCoord());
  }

  @Test
  public void shouldExecuteOnSuccessfullyInEastFacingTurnRightScenario() {
    // given
    CartesianPosition position = CartesianPosition.builder().orientation(E).xCoord(1).yCoord(1)
        .build();
    CartesianCommand underTest = CartesianCommand.builder().command(R).build();

    // when
    CartesianPosition result = (CartesianPosition) underTest.executeOn(position);

    // then
    assertNotNull(result);
    assertTrue(result.getOrientation().equals(S));
    assertEquals(position.getXCoord(), result.getXCoord());
    assertEquals(position.getYCoord(), result.getYCoord());
  }

  @Test
  public void shouldExecuteOnSuccessfullyInEastFacingTurnLeftScenario() {
    // given
    CartesianPosition position = CartesianPosition.builder().orientation(E).xCoord(1).yCoord(1)
        .build();
    CartesianCommand underTest = CartesianCommand.builder().command(L).build();

    // when
    CartesianPosition result = (CartesianPosition) underTest.executeOn(position);

    // then
    assertNotNull(result);
    assertTrue(result.getOrientation().equals(N));
    assertEquals(position.getXCoord(), result.getXCoord());
    assertEquals(position.getYCoord(), result.getYCoord());
  }

  @Test
  public void shouldExecuteOnSuccessfullyInEastFacingGoForwardScenario() {
    // given
    CartesianPosition position = CartesianPosition.builder().orientation(E).xCoord(1).yCoord(1)
        .build();
    CartesianCommand underTest = CartesianCommand.builder().command(F).build();

    // when
    CartesianPosition result = (CartesianPosition) underTest.executeOn(position);

    // then
    assertNotNull(result);
    assertTrue(result.getOrientation().equals(E));
    assertEquals(position.getXCoord() + 1, result.getXCoord());
    assertEquals(position.getYCoord(), result.getYCoord());
  }

  @Test
  public void shouldExecuteOnSuccessfullyInWestFacingTurnRightScenario() {
    // given
    CartesianPosition position = CartesianPosition.builder().orientation(W).xCoord(1).yCoord(1)
        .build();
    CartesianCommand underTest = CartesianCommand.builder().command(R).build();

    // when
    CartesianPosition result = (CartesianPosition) underTest.executeOn(position);

    // then
    assertNotNull(result);
    assertTrue(result.getOrientation().equals(N));
    assertEquals(position.getXCoord(), result.getXCoord());
    assertEquals(position.getYCoord(), result.getYCoord());
  }

  @Test
  public void shouldExecuteOnSuccessfullyInWestFacingTurnLeftScenario() {
    // given
    CartesianPosition position = CartesianPosition.builder().orientation(W).xCoord(1).yCoord(1)
        .build();
    CartesianCommand underTest = CartesianCommand.builder().command(L).build();

    // when
    CartesianPosition result = (CartesianPosition) underTest.executeOn(position);

    // then
    assertNotNull(result);
    assertTrue(result.getOrientation().equals(S));
    assertEquals(position.getXCoord(), result.getXCoord());
    assertEquals(position.getYCoord(), result.getYCoord());
  }

  @Test
  public void shouldExecuteOnSuccessfullyInWestFacingGoForwardScenario() {
    // given
    CartesianPosition position = CartesianPosition.builder().orientation(W).xCoord(1).yCoord(1)
        .build();
    CartesianCommand underTest = CartesianCommand.builder().command(F).build();

    // when
    CartesianPosition result = (CartesianPosition) underTest.executeOn(position);

    // then
    assertNotNull(result);
    assertTrue(result.getOrientation().equals(W));
    assertEquals(position.getXCoord() - 1, result.getXCoord());
    assertEquals(position.getYCoord(), result.getYCoord());
  }
}
