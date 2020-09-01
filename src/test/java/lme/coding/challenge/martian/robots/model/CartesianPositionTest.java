package lme.coding.challenge.martian.robots.model;

import static lme.coding.challenge.martian.robots.model.Orientations.N;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

public class CartesianPositionTest {

  @Test
  public void shouldConstructSuccessfully() {
    // given
    int expectedXCoord = 1;
    int expectedYCoord = 2;
    Orientations expectedOrientation = N;

    // when
    CartesianPosition underTest = new CartesianPosition(expectedXCoord, expectedYCoord,
        expectedOrientation);

    // then
    assertNotNull(underTest);
    assertEquals(expectedXCoord, underTest.getXCoord());
    assertEquals(expectedYCoord, underTest.getYCoord());
    assertEquals(expectedOrientation, underTest.getOrientation());
  }
}
