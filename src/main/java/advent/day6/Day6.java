package advent.day6;

import java.util.*;

public class Day6 {

    public int calculateAnswers(final List<String> values) {
        Set<String> resultSet = new HashSet<>();

        values.stream()
                .flatMap(i -> Arrays.stream(i.split("")))
                .forEach(resultSet::add);

        return resultSet.size();
    }

    public int calculateAllAnswers(final List<String> values) {
        final Map<String, Integer> frequency = new HashMap<>();

        values.stream()
                .flatMap(i -> Arrays.stream(i.split("")))
                .forEach(s -> frequency.put(s, frequency.getOrDefault(s, 0) + 1));

        return (int) frequency.values()
                .stream()
                .filter(x -> x == values.size())
                .count();
    }


    public int calculateTotalAnswers(List<List<String>> valuesList) {
        return valuesList.stream()
                .map(this::calculateAnswers)
                .reduce(0, Integer::sum);
    }

    public int calculateTotalAllAnswers(List<List<String>> valuesList) {
        return valuesList.stream()
                .map(this::calculateAllAnswers)
                .reduce(0, Integer::sum);
    }
}
