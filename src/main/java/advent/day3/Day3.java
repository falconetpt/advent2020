package advent.day3;

import java.awt.*;
import java.util.List;

public class Day3 {
    public int countChoppedTrees(final List<String> values, final int start, final Point point) {
        int result = 0;
        int position = start;

        for (int i = point.y, n = values.size(); i < n; i+=point.y) {
            final int localValue = values.get(i).length();
            position = (position + point.x) % localValue;
            result += values.get(i).charAt(position) == '#' ? 1 : 0;
        }

        return result;
    }

    public int countChoppedTrees(final List<String> values, final int start, final List<Point> points) {
        return points.stream().parallel()
                .map(p -> countChoppedTrees(values, start, p))
                .reduce((a, b) -> a * b)
                .orElse(0);
    }

}
