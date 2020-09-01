package lme.coding.challenge.martian.robots.model;

import static lme.coding.challenge.martian.robots.model.CartesianCommand.Commands.F;
import static lme.coding.challenge.martian.robots.model.CartesianCommand.Commands.L;
import static lme.coding.challenge.martian.robots.model.CartesianCommand.Commands.R;
import static lme.coding.challenge.martian.robots.model.Orientations.E;
import static lme.coding.challenge.martian.robots.model.Orientations.N;
import static lme.coding.challenge.martian.robots.model.Orientations.S;
import static lme.coding.challenge.martian.robots.model.Orientations.W;

import lombok.Builder;
import org.javatuples.Pair;

@Builder
public class CartesianCommand implements Command {

  private Commands command;

  @Override
  public Position executeOn(Position positionMovingFrom) {
    CartesianPosition cartesianPosition = (CartesianPosition) positionMovingFrom;
    Orientations newOrientation = getNewOrientation(this.command,
        cartesianPosition.getOrientation());

    if (this.command != F) {
      return CartesianPosition.builder()
          .orientation(newOrientation).xCoord(
              cartesianPosition.getXCoord()).yCoord(cartesianPosition.getYCoord()).build();
    }

    Pair<Integer, Integer> newCoords = getNewCoords(cartesianPosition, newOrientation);
    return CartesianPosition.builder().orientation(newOrientation).xCoord(newCoords.getValue0())
        .yCoord(newCoords.getValue1()).build();

  }

  private Orientations getNewOrientation(Commands command, Orientations currentOrientation) {
    switch (currentOrientation) {
      case N:
        return handleNorthFacingScenario(command);
      case S:
        return handleSouthFacingScenario(command);
      case E:
        return handleEastFacingScenario(command);
      case W:
        return handleWestFacingScenario(command);
    }
    return currentOrientation;
  }

  private Orientations handleNorthFacingScenario(Commands command) {
    if (command.equals(R)) {
      return E;
    }
    if (command.equals(L)) {
      return W;
    }

    return N;
  }

  private Orientations handleSouthFacingScenario(Commands command) {
    if (command.equals(R)) {
      return W;
    }
    if (command.equals(L)) {
      return E;
    }

    return S;
  }

  private Orientations handleEastFacingScenario(Commands command) {
    if (command.equals(R)) {
      return S;
    }
    if (command.equals(L)) {
      return N;
    }

    return E;
  }

  private Orientations handleWestFacingScenario(Commands command) {
    if (command.equals(R)) {
      return N;
    }
    if (command.equals(L)) {
      return S;
    }

    return W;
  }

  private Pair<Integer, Integer> getNewCoords(CartesianPosition positionMovingFrom,
      Orientations orientation) {
    switch (orientation) {
      case N:
        return getNewCoordsWhenNorthFacing(positionMovingFrom);
      case S:
        return getNewCoordsWhenSouthFacing(positionMovingFrom);
      case E:
        return getNewCoordsWhenEastFacing(positionMovingFrom);
      case W:
        return getNewCoordsWhenWestFacing(positionMovingFrom);
    }
    return new Pair<>(positionMovingFrom.getXCoord(), positionMovingFrom.getYCoord());
  }

  private Pair<Integer, Integer> getNewCoordsWhenNorthFacing(CartesianPosition positionMovingFrom) {
    return new Pair<>(positionMovingFrom.getXCoord(), positionMovingFrom.getYCoord() + 1);
  }

  private Pair<Integer, Integer> getNewCoordsWhenSouthFacing(CartesianPosition positionMovingFrom) {
    return new Pair<>(positionMovingFrom.getXCoord(), positionMovingFrom.getYCoord() - 1);
  }

  private Pair<Integer, Integer> getNewCoordsWhenEastFacing(CartesianPosition positionMovingFrom) {
    return new Pair<>(positionMovingFrom.getXCoord() + 1, positionMovingFrom.getYCoord());
  }

  private Pair<Integer, Integer> getNewCoordsWhenWestFacing(CartesianPosition positionMovingFrom) {
    return new Pair<>(positionMovingFrom.getXCoord() - 1, positionMovingFrom.getYCoord());
  }

  public enum Commands {R, F, L,}
}
