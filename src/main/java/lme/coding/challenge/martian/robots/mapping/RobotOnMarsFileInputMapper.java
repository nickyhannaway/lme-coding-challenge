package lme.coding.challenge.martian.robots.mapping;

import static java.util.Arrays.asList;
import static java.util.Arrays.stream;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lme.coding.challenge.martian.robots.model.CartesianCommand;
import lme.coding.challenge.martian.robots.model.CartesianLandscape;
import lme.coding.challenge.martian.robots.model.CartesianPosition;
import lme.coding.challenge.martian.robots.model.Orientations;
import lme.coding.challenge.martian.robots.model.Robot;
import lombok.SneakyThrows;
import org.apache.commons.io.FileUtils;

public class RobotOnMarsFileInputMapper {

  private final static int LANDSCAPE_DEF_ROW = 0;
  private final static String ROBOT_DELIMITER = "\r\n\r\n";
  private final static String ROBOT_DETAIL_DELIMITER = "\r\n";

  private final String inputFileLocation;
  private String rawFileContent;

  @SneakyThrows
  public RobotOnMarsFileInputMapper(String inputFileLocation) {
    this.inputFileLocation = inputFileLocation;
    readRawFileInput();
  }

  private void readRawFileInput() throws IOException {
    String fullPath = getClass().getClassLoader().getResource(inputFileLocation).getFile();
    File file = new File(fullPath);
    rawFileContent = FileUtils.readFileToString(file, StandardCharsets.UTF_8);
  }

  public CartesianLandscape mapCartesianLandscape() {
    String[] rawLandscapeDef = rawFileContent.split(System.lineSeparator(), 1);
    int xBoundary = Integer.parseInt(rawLandscapeDef[0].split("")[0]);
    int yBoundary = Integer.parseInt(rawLandscapeDef[0].split("")[1]);
    return new CartesianLandscape(xBoundary, yBoundary);
  }

  public List<Robot> mapRobots() {
    List<String> robotRawData = asList(rawFileContent.split(ROBOT_DELIMITER));
    List<Robot> robots = new ArrayList<>();
    for (int i = 0; i < robotRawData.size(); i++) {
      String[] robotParts = robotRawData.get(i).split(ROBOT_DETAIL_DELIMITER);
      if (i == LANDSCAPE_DEF_ROW) {
        robots.add(Robot.builder().currentPosition(mapStartingPosition(robotParts[1]))
            .commands(mapCommands(robotParts[2])).build());
      } else {
        robots.add(Robot.builder().currentPosition(mapStartingPosition(robotParts[0]))
            .commands(mapCommands(robotParts[1])).build());
      }
    }
    return robots;
  }

  private CartesianPosition mapStartingPosition(String rawPosition) {
    String[] splitRawData = rawPosition.split("");
    return CartesianPosition.builder().xCoord(Integer.parseInt(splitRawData[0]))
        .yCoord(Integer.parseInt(splitRawData[1]))
        .orientation(Orientations.valueOf(splitRawData[2])).build();
  }

  private List<CartesianCommand.Commands> mapCommands(String rawInstructionSet) {
    String[] splitRawData = rawInstructionSet.split("");
    return stream(splitRawData).map(x -> CartesianCommand.Commands.valueOf(x))
        .collect(Collectors.toList());
  }
}
