package lme.coding.challenge.martian.robots.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CartesianPosition implements Position {

  private final int xCoord;
  private final int yCoord;
  private final Orientations orientation;
}
