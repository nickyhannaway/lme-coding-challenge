package lme.coding.challenge.martian.robots.model;

import java.util.HashSet;
import java.util.Set;
import lme.coding.challenge.martian.robots.exception.InvalidLandscapeException;
import lombok.Builder;
import lombok.Data;

@Data
public class CartesianLandscape implements Landscape {

  private final int xCoordBoundary;
  private final int yCoordBoundary;
  private Set<CartesianPosition> positionsWithScent;

  @Builder
  public CartesianLandscape(int xCoordBoundary, int yCoordBoundary) {
    validateLandscape(xCoordBoundary, yCoordBoundary);
    this.xCoordBoundary = xCoordBoundary;
    this.yCoordBoundary = yCoordBoundary;
    this.positionsWithScent = new HashSet<>();
  }

  @Override
  public boolean isOffTheRadar(Position position) {
    CartesianPosition cartesianPosition = (CartesianPosition) position;
    return cartesianPosition.getXCoord() > this.xCoordBoundary
        || cartesianPosition.getYCoord() > this.yCoordBoundary;
  }

  @Override
  public boolean positionHasScent(Position position) {
    return positionExistsWithScent((CartesianPosition) position);
  }

  @Override
  public void markScentOnLandscape(Position position) {
    positionsWithScent.add((CartesianPosition) position);
  }

  private boolean positionExistsWithScent(CartesianPosition position) {
    return positionsWithScent.stream().anyMatch(
        x -> x.getXCoord() == position.getXCoord() && x.getYCoord() == position
            .getYCoord());
  }

  private void validateLandscape(int xCoordBoundary, int yCoordBoundary) {
    if (breachesLowerThreshold(xCoordBoundary, yCoordBoundary) || breachesHigherThreshold(
        xCoordBoundary, yCoordBoundary)) {
      throw new InvalidLandscapeException(String.format(
          "The boundaries for a cartesian landscape should be in the range (0,0) - (50,50) those supplied were (%s,%s) and thus invlaid",
          xCoordBoundary, yCoordBoundary));
    }
  }

  private boolean breachesLowerThreshold(int xCoordBoundary, int yCoordBoundary) {
    return xCoordBoundary < 0 || yCoordBoundary < 0;
  }

  private boolean breachesHigherThreshold(int xCoordBoundary, int yCoordBoundary) {
    return xCoordBoundary > 50 || yCoordBoundary > 50;
  }
}
