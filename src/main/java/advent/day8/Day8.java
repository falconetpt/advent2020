package advent.day8;

import advent.day8.command.Command;
import advent.day8.command.Jump;
import advent.day8.command.NoOperation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Day8 {
    public int calculateAccumulator(final List<Command> commandList) {
        return calculateAccumulator(commandList, 0, new HashSet<>(), 0);
    }

    public int calculateAccumulatorWithSwaps(final List<Command> values) {
        return generateSwappedInput(values, 0, new ArrayList<>());
    }

    private int generateSwappedInput(final List<Command> values,
                                                     final int i,
                                                     final List<List<Command>> result) {
        if (i >= values.size()) {
            return 0;
        } else {
            final Command command = values.get(i);

            if (Stream.of("nop", "jmp").anyMatch(x -> values.get(i).getName().equals(x))) {
                List<Command> listToAdd = IntStream.range(0, i).boxed()
                        .map(values::get)
                        .collect(Collectors.toList());
                listToAdd.add(
                        command.getName().equals("jmp")
                            ? new NoOperation(command.getValue())
                            : new Jump(command.getValue())
                        );
                IntStream.range(i + 1, values.size()).boxed()
                        .map(values::get)
                        .forEach(listToAdd::add);

                int value = calculateAccumulatorWithSwap(listToAdd, 0, new HashSet<>(), 0);

                if (value > 0) return value;
            }


            return generateSwappedInput(values, i + 1, result);
        }
    }

    private int calculateAccumulatorWithSwap(final List<Command> commandList,
                                     final int i,
                                     final HashSet<Integer> seenOffset,
                                     final int result) {
        if (seenOffset.contains(i)) {
            return 0;
        } else if (i >= commandList.size()) {
            return result;
        } else {
            Command element = commandList.get(i);
            seenOffset.add(i);

            return calculateAccumulatorWithSwap(
                    commandList,
                    i + element.getJump(),
                    seenOffset,
                    result + element.getAccumulation()
            );
        }
    }

    private int calculateAccumulator(final List<Command> commandList,
                                     final int i,
                                     final HashSet<Integer> seenOffset,
                                     final int result) {
        if (seenOffset.contains(i)) {
            return result;
        } else {
            Command element = commandList.get(i);
            seenOffset.add(i);

            return calculateAccumulator(
                    commandList,
                    i + element.getJump(),
                    seenOffset,
                    result + element.getAccumulation()
            );
        }
    }
}
