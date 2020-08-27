package lme.coding.challenge.martian.robots.model;

import javax.crypto.Mac;

public class Robot implements Machine {
    @Override
    public Position getCurrentPosition() {
        return null;
    }

    @Override
    public void move(Instruction instruction) {

    }

    @Override
    public boolean isLost() {
        return false;
    }
}
