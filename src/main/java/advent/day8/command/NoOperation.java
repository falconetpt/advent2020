package advent.day8.command;

public class NoOperation implements Command {
    private int value;

    public NoOperation(final int value) {
        this.value = value;
    }

    @Override
    public int getJump() {
        return +1;
    }

    @Override
    public int getAccumulation() {
        return 0;
    }

    @Override
    public int getValue() {
        return value;
    }

    @Override
    public String getName() {
        return "nop";
    }
}
