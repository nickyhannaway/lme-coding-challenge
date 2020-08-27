package lme.coding.challenge.martian.robots.model;

public interface Machine {
    Position getCurrentPosition();
    void move(Instruction instruction);
    boolean isLost();
}
