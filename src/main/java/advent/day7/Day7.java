package advent.day7;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Day7 {
    public int countShinyGoldBad(final List<String> list) {
        Map<String, BagInfo> set = new HashMap<>();

        list.forEach(x -> fillSet(x, set));

        return (int) set.values().stream()
                .filter(x -> x.contains("shiny gold bags"))
                .count();
    }

    private void fillSet(final String x, final Map<String, BagInfo> set) {
        String[] values = x.split(" ");
        String key = IntStream.range(0, 3).boxed()
                .map(i -> values[i])
                .collect(Collectors.joining(" "));

        set.putIfAbsent(key, new BagInfo(key));

        fillSet(values, 4, set, key);
    }

    private void fillSet(String[] values, int i, Map<String, BagInfo> set, String parent) {
        if (i <= values.length - 4) {
            String value = values[i + 1] + " " + values[i+2] + " " + "bags";

            set.putIfAbsent(value, new BagInfo(value));
            set.get(parent).bagInfo.put(set.get(value), Integer.parseInt(values[i]));

            fillSet(values, i + 4, set, parent);
        }
    }

    public int countShinyAllGoldBad(final List<String> list) {
        Map<String, BagInfo> set = new HashMap<>();

        list.forEach(x -> fillSet(x, set));

        return set.get("shiny gold bags").calculateTotalBags();
    }

    private class BagInfo {
        private Map<BagInfo, Integer> bagInfo;
        private String name;

        public BagInfo(final String name) {
            this.name = name;
            this.bagInfo = new HashMap<>();
        }

        public boolean contains(final String value) {
            if (bagInfo.isEmpty()) {
                return false;
            } else {
                if (bagInfo.containsKey(new BagInfo(value))) return true;

                return bagInfo.keySet().stream()
                        .map(b -> b.contains(value))
                        .reduce(false, (a, b) -> a || b);
            }
        }

        public int calculateTotalBags() {
            return bagInfo.keySet().stream()
                    .map(k -> bagInfo.get(k) + bagInfo.get(k) * k.calculateTotalBags())
                    .reduce(0, Integer::sum);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            BagInfo bagInfo = (BagInfo) o;
            return Objects.equals(name, bagInfo.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name);
        }
    }
}
