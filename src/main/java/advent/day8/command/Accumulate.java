package advent.day8.command;

public class Accumulate implements Command {
    private int accumulator;

    public Accumulate(final int accumulator) {
        this.accumulator = accumulator;
    }

    @Override
    public int getJump() {
        return +1;
    }

    @Override
    public int getAccumulation() {
        return accumulator;
    }

    @Override
    public int getValue() {
        return accumulator;
    }

    @Override
    public String getName() {
        return "acc";
    }
}
