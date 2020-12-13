package advent.day5;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Day5 {
    public int calculateMaxSeatId(final List<String> values) {
        return values.stream()
                .map(this::calculateSeatId)
                .max(Integer::compareTo)
                .orElse(0);
    }

    public int calculateSeatId(final List<String> values) {
        Set<Integer> foundSeats = values.stream()
                .map(this::calculateSeatId)
                .collect(Collectors.toSet());

        return IntStream.range(0, 127 * 8 + 7)
                .filter(i -> !foundSeats.contains(i))
                .filter(i -> foundSeats.contains(i - 1) && foundSeats.contains(i + 1))
                .findFirst()
                .orElse(0);
    }

    public int calculateSeatId(final String command) {
        return calculateRow(command, 0, command.length() - 3, 0, 127) * 8
                + calculateColumn(command, command.length() - 3, command.length(), 0, 7);
    }

    private int calculateRow(final String command, final int index, int limit, int start, int end) {
        if (index >= limit) {
            return start;
        } else {
            char value = command.charAt(index);

            if (value == 'F') {
                return calculateRow(command, index + 1, limit, start, (start + end) / 2);
            } else {
                return calculateRow(command, index + 1, limit, (start + end + 1) / 2, end);
            }
        }
    }

    private int calculateColumn(final String command, final int index, int limit, int start, int end) {
        if (index >= limit) {
            return start;
        } else {
            char value = command.charAt(index);

            if (value == 'L') {
                return calculateColumn(command, index + 1, limit, start, (start + end) / 2);
            } else {
                return calculateColumn(command, index + 1, limit, (start + end + 1) / 2, end);
            }
        }
    }
}
