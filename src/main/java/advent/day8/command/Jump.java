package advent.day8.command;

public class Jump implements Command {
    private int jump;

    public Jump(final int jump) {
        this.jump = jump;
    }

    @Override
    public int getJump() {
        return jump;
    }

    @Override
    public int getAccumulation() {
        return 0;
    }

    @Override
    public int getValue() {
        return jump;
    }

    @Override
    public String getName() {
        return "jmp";
    }
}
