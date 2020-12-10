package advent.day4;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Day4 {
    public int countValidPassports(final List<String> values,
                                   final Set<String> mandatoryFields,
                                   final Set<String> optionalFields) {
        return (int) values.stream().parallel()
                .filter(v -> isValidPassPort(v, mandatoryFields, optionalFields))
                .count();
    }

    public int countValidPassportsWithValidation(final List<String> values,
                                   final Set<String> mandatoryFields,
                                   final Set<String> optionalFields) {
        Map<String, Predicate<String>> map = new HashMap<>();
        map.put("byr", this::validByr);
        map.put("iyr", this::validIyr);
        map.put("eyr", this::validEyr);
        map.put("hgt", this::validHgt);
        map.put("hcl", this::validHcl);
        map.put("ecl", this::validEcl);
        map.put("pid", this::validPid);

        return (int) values.stream().parallel()
                .filter(v -> isValidPassPort(v, mandatoryFields, optionalFields, map))
                .count();
    }

    private boolean validByr(final String s) {
        try {
            int value = Integer.parseInt(s);
            return value >= 1920 && value <= 2002;
        } catch (final Exception e) {
            return false;
        }
    }

    private boolean validIyr(final String s) {
        try {
            int value = Integer.parseInt(s);
            return value >= 2010 && value <= 2020;
        } catch (final Exception e) {
            return false;
        }
    }

    private boolean validEyr(final String s) {
        try {
            int value = Integer.parseInt(s);
            return value >= 2020 && value <= 2030;
        } catch (final Exception e) {
            return false;
        }
    }

    private boolean validHgt(final String s) {
        try {
            int value = Integer.parseInt(s.replaceAll("[a-z]*", ""));
            String measure = s.replaceAll("[0-9]*", "");
            return ( measure.equals("cm") && value >= 150 && value <= 193 )
                    || ( measure.equals("in") && value >= 59 && value <= 76 );
        } catch (final Exception e) {
            return false;
        }
    }

    private boolean validHcl(final String s) {
        return s.matches("#[0-9a-z]{6}");
    }

    private boolean validEcl(final String s) {
        return List.of("amb", "blu", "brn", "gry", "grn", "hzl", "oth")
                .contains(s);
    }

    private boolean validPid(final String s) {
        return s.matches("[0-9]{9}");
    }

    private boolean isValidPassPort(final String v,
                                    final Set<String> mandatoryFields,
                                    final Set<String> optionalFields) {
        return Arrays.stream(v.split(" "))
                .map(x -> x.split(":")[0])
                .filter(mandatoryFields::contains)
                .distinct()
                .count() == mandatoryFields.size();
    }

    private boolean isValidPassPort(final String v,
                                    final Set<String> mandatoryFields,
                                    final Set<String> optionalFields,
                                    final Map<String, Predicate<String>> map) {
        return Arrays.stream(v.split(" "))
                .filter(x -> map.getOrDefault(x.split(":")[0], (String s) -> false).test(x.split(":")[1]))
                .distinct()
                .count() == mandatoryFields.size();
    }
}
