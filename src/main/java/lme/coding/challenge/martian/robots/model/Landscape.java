package lme.coding.challenge.martian.robots.model;

public interface Landscape {

  boolean isOffTheRadar(Position position);

  boolean positionHasScent(Position position);

  void markScentOnLandscape(Position position);
}
