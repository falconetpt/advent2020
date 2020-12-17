package advent.day8.command;

public class CommandFactory {
    public static Command createCommand(final String input) {
        String[] values = input.split(" ");
        String command =  values[0];
        int value = values.length > 1 ? Integer.parseInt(values[1]) : 0;

        switch (command) {
            case "nop":
                return new NoOperation(value);
            case "acc":
                return new Accumulate(value);
            case "jmp":
                return new Jump(value);
            default:
                return null;
        }
    }
}
