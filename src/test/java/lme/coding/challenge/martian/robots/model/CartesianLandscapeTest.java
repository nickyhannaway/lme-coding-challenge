package lme.coding.challenge.martian.robots.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import lme.coding.challenge.martian.robots.exception.InvalidLandscapeException;
import org.junit.jupiter.api.Test;

public class CartesianLandscapeTest {

  @Test
  public void shouldConstructSuccessfully() {
    // given
    int expectedXCoord = 1;
    int expectedYCoord = 2;

    // when
    CartesianLandscape underTest = CartesianLandscape.builder().xCoordBoundary(expectedXCoord)
        .yCoordBoundary(expectedYCoord)
        .build();

    // then
    assertNotNull(underTest);
    assertEquals(expectedXCoord, underTest.getXCoordBoundary());
    assertEquals(expectedYCoord, underTest.getYCoordBoundary());

  }

  @Test
  public void shouldThrowIvalidLandscapeExceptionForLandscapeThatIsTooSmall() {
    assertThrows(InvalidLandscapeException.class,
        () -> CartesianLandscape.builder().xCoordBoundary(-1)
            .yCoordBoundary(-1)
            .build());
  }

  @Test
  public void shouldThrowIvalidLandscapeExceptionForLandscapeThatIsTooLarge() {
    assertThrows(InvalidLandscapeException.class,
        () -> CartesianLandscape.builder().xCoordBoundary(51)
            .yCoordBoundary(51)
            .build());
  }

  @Test
  public void shouldNotBeOffTheRadarForValidXAndYCoords() {
    // given
    CartesianLandscape underTest = CartesianLandscape.builder().xCoordBoundary(5).yCoordBoundary(5)
        .build();
    CartesianPosition position = CartesianPosition.builder().xCoord(4).yCoord(4).build();

    // when
    boolean result = underTest.isOffTheRadar(position);

    // then
    assertFalse(result);
  }

  @Test
  public void shouldBeOffTheRadarForExceededXCoord() {
    // given
    CartesianLandscape underTest = CartesianLandscape.builder().xCoordBoundary(5).yCoordBoundary(5)
        .build();
    CartesianPosition position = CartesianPosition.builder().xCoord(6).yCoord(4).build();

    // when
    boolean result = underTest.isOffTheRadar(position);

    // then
    assertTrue(result);
  }

  @Test
  public void shouldBeOffTheRadarForExceededYCoord() {
    // given
    CartesianLandscape underTest = CartesianLandscape.builder().xCoordBoundary(5).yCoordBoundary(5)
        .build();
    CartesianPosition position = CartesianPosition.builder().xCoord(4).yCoord(6).build();

    // when
    boolean result = underTest.isOffTheRadar(position);

    // then
    assertTrue(result);
  }

  @Test
  public void shouldBeOffTheRadarForExceededXAndYCoords() {
    // given
    CartesianLandscape underTest = CartesianLandscape.builder().xCoordBoundary(5).yCoordBoundary(5)
        .build();
    CartesianPosition position = CartesianPosition.builder().xCoord(6).yCoord(6).build();

    // when
    boolean result = underTest.isOffTheRadar(position);

    // then
    assertTrue(result);
  }

  @Test
  public void positionHasScentShouldBeTrue() {
    // given
    CartesianLandscape underTest = CartesianLandscape.builder().xCoordBoundary(5).yCoordBoundary(5)
        .build();
    CartesianPosition position = CartesianPosition.builder().xCoord(6).yCoord(6).build();
    underTest.markScentOnLandscape(position);

    // when
    boolean result = underTest.positionHasScent(position);

    // then
    assertTrue(result);
  }

  @Test
  public void positionHasScentShouldBeFalse() {
    // given
    CartesianLandscape underTest = CartesianLandscape.builder().xCoordBoundary(5).yCoordBoundary(5)
        .build();
    CartesianPosition position = CartesianPosition.builder().xCoord(6).yCoord(6).build();

    // when
    boolean result = underTest.positionHasScent(position);

    // then
    assertFalse(result);
  }

  @Test
  public void markScentOnLandscape() {
    // given
    CartesianLandscape underTest = CartesianLandscape.builder().xCoordBoundary(5).yCoordBoundary(5)
        .build();
    CartesianPosition position = CartesianPosition.builder().xCoord(6).yCoord(6).build();
    assertFalse(underTest.positionHasScent(position));

    // when
    underTest.markScentOnLandscape(position);

    // then
    assertTrue(underTest.positionHasScent(position));
  }
}
