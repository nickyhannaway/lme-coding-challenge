package lme.coding.challenge.martian.robots.config;

import lme.coding.challenge.martian.robots.RobotOnMarsRunner;
import lme.coding.challenge.martian.robots.mapping.RobotOnMarsFileInputMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RobotOnMarsConfig {

  @Value("${input.file}")
  private String inputFileLocation;

  @Bean
  public String getInputFileLocation() {
    return this.inputFileLocation;
  }

  @Bean
  public RobotOnMarsFileInputMapper getRobotOnMarsFileInputMapper() {
    return new RobotOnMarsFileInputMapper(getInputFileLocation());
  }

  @Bean
  public RobotOnMarsRunner getRobotOnMarsRunner() {
    return new RobotOnMarsRunner();
  }

}
