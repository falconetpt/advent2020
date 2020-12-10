package advent.day2;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Day2 {
    public int countValidPasswords(final List<String> input) {
        return (int) input.stream().parallel()
                .filter(this::isValidCount)
                .count();
    }

    public int countValidPassWordsInPosition(final List<String> input) {
        return (int) input.stream().parallel()
                .filter(this::isValidCountWithPosition)
                .count();
    }

    private boolean isValidCountWithPosition(String s) {
        final String[] elements = s.split(":");
        final String pass = elements[1].trim();
        final String[] valid = elements[0].split(" ");
        final char word = valid[1].charAt(0);
        final int[] range = extractRange(valid[0]);

        return pass.charAt(range[0] - 1) == word ^ pass.charAt(range[1] - 1) == word;
    }

    private boolean isValidCount(final String s) {
        final String[] elements = s.split(":");
        final String pass = elements[1].trim();
        final String[] valid = elements[0].split(" ");
        final String word = valid[1];
        final int[] range = extractRange(valid[0]);

        Map<String, Long> frequency = Arrays.stream(pass.split(""))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        return frequency.getOrDefault(word, 0L) >= range[0]
                && frequency.getOrDefault(word, 0L) <= range[1];
    }

    public int[] extractRange(final String rangeStr) {
        final String[] range = rangeStr.split("-");
        return new int[] { Integer.parseInt(range[0]), Integer.parseInt(range[1]) };
    }
}
