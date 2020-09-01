package lme.coding.challenge.martian.robots.model;

public interface Command {

  Position executeOn(Position currentPosition);
}
