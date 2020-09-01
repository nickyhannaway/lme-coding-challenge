package lme.coding.challenge.martian.robots.model;

public interface Machine {

  Position getCurrentPosition();

  void explore(Landscape landscape);

  boolean isLost();
}
