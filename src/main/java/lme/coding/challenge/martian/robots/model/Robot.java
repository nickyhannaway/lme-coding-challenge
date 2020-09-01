package lme.coding.challenge.martian.robots.model;

import java.util.List;
import lombok.Builder;

@Builder
public class Robot implements Machine {

  private final List<CartesianCommand.Commands> commands;
  private boolean isLost;
  private Position currentPosition;

  @Override
  public Position getCurrentPosition() {
    return this.currentPosition;
  }

  @Override
  public void explore(Landscape landscape) {
    commands.stream().forEach(x -> executeCommand(x, landscape));
  }

  private void executeCommand(CartesianCommand.Commands command, Landscape landscape) {
    if (this.isLost) {
      return;
    }

    CartesianCommand commandToExecute = CartesianCommand.builder().command(command).build();
    Position newPosition = commandToExecute.executeOn(this.currentPosition);

    if (landscape.isOffTheRadar(newPosition) && landscape.positionHasScent(this.currentPosition)) {
      return;
    }

    if (landscape.isOffTheRadar(newPosition) && !landscape.positionHasScent(currentPosition)) {
      landscape.markScentOnLandscape(this.currentPosition);
      this.isLost = true;
      return;
    }

    this.currentPosition = newPosition;
  }

  @Override
  public boolean isLost() {
    return this.isLost;
  }
}
