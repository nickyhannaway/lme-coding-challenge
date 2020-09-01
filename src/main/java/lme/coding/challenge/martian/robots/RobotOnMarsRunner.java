package lme.coding.challenge.martian.robots;

import java.util.List;
import lme.coding.challenge.martian.robots.mapping.RobotOnMarsFileInputMapper;
import lme.coding.challenge.martian.robots.model.CartesianLandscape;
import lme.coding.challenge.martian.robots.model.Robot;
import lme.coding.challenge.martian.robots.output.OutputPrinter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@NoArgsConstructor
public class RobotOnMarsRunner {

  @Autowired
  RobotOnMarsFileInputMapper fileInputMapper;

  public void run() {
    CartesianLandscape landscape = fileInputMapper.mapCartesianLandscape();
    List<Robot> robots = fileInputMapper.mapRobots();
    robots.stream().forEach(x -> x.explore(landscape));
    OutputPrinter.printRobotFinalPositions(robots);
  }
}
