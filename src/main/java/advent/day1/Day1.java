package advent.day1;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Day1 {
    public int multiplyTwoNumbersThatSumUpTo(final List<Integer> l, final int sumUpTo) {
        return multiplyTwoNumbersThatSumUpTo( l, 0, sumUpTo, new HashSet<>());
    }

    public String multiplyThreeNumbersThatSumUpTo(final List<Integer> l, final int sumUpTo) {
        for (int i = 0; i < l.size(); i++) {
            int result = multiplyTwoNumbersThatSumUpTo(l, i + 1, sumUpTo - l.get(i), new HashSet<>());

            if (result > 0)
                return BigInteger.valueOf(l.get(i))
                    .multiply(BigInteger.valueOf(result))
                    .toString();
        }

        return "0";
    }

    private int multiplyTwoNumbersThatSumUpTo(List<Integer> l, int i, int sumUpTo, Set<Integer> seen) {
        if (i >= l.size()) {
            return 0;
        } else {
            int number = l.get(i);
            int dif = sumUpTo - number;

            if (seen.contains(dif)) return dif * number;

            seen.add(number);

            return multiplyTwoNumbersThatSumUpTo(l, i + 1, sumUpTo, seen);
        }
    }
}
