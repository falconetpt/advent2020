package advent.day9;

import java.math.BigInteger;
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Day9 {
    public int getFirstError(final List<BigInteger> numbers, final int preambule, final int index) {
        return IntStream.range(preambule, numbers.size()).boxed()
                .filter(i -> isInvalidNumber(numbers, i - preambule, preambule, new HashSet<>(), numbers.get(i)))
                .map(numbers::get)
                .findFirst()
                .orElse(new BigInteger("0"))
                .intValue();
    }

    public int getFirstErrorWithRangeSum(final List<BigInteger> numbers, final int preambule, final int index) {
        return IntStream.range(preambule, numbers.size()).boxed()
                .filter(i -> isInvalidNumber(numbers, i - preambule, preambule, new HashSet<>(), numbers.get(i)))
                .map(i -> getSumNumber(0, numbers, numbers.get(i)))
                .findFirst()
                .orElse(new BigInteger("0"))
                .intValue();
    }

    private BigInteger getSumNumber(int start, List<BigInteger> numbers, BigInteger target) {
        Queue<BigInteger> queue = new LinkedList<>();
        queue.add(numbers.get(start));

        return getSumNumber(start + 1, numbers, target, queue, numbers.get(start));
    }

    private BigInteger getSumNumber(int index,
                                    List<BigInteger> numbers,
                                    BigInteger target,
                                    Queue<BigInteger> queue,
                                    BigInteger sum) {
        var element = numbers.get(index);
        var newSum = sum.add(element);

        if (newSum.equals(target)) {
            queue.add(element);
            return queue.stream()
                    .min(BigInteger::compareTo)
                    .orElse(BigInteger.ZERO)
                    .add( queue.stream()
                            .max(BigInteger::compareTo)
                            .orElse(BigInteger.ZERO));
        }

        if (newSum.compareTo(target) > 0) {
            var elementToRemove = queue.poll();
            return getSumNumber(index, numbers, target, queue, sum.subtract(elementToRemove));
        }

        queue.add(element);

        return getSumNumber(index + 1, numbers, target, queue, newSum);
    }

    private boolean isInvalidNumber(final List<BigInteger> numbers,
                                    int index,
                                    int preambule,
                                    Set<BigInteger> integers,
                                    BigInteger target) {
        if (preambule == 0) {
            return true;
        } else {
            var number = numbers.get(index);
            var value = target.subtract(number);

            if (integers.contains(value)) {
                return false;
            } else {
                integers.add(number);
                return isInvalidNumber(numbers, index + 1, preambule - 1, integers, target);
            }
        }
    }
}
