import java.util.List;

public final class StatisticsCollector {
    /**
     * вычисляет статистику для списка целых чисел
     * @param numbers список целых чисел
     * @return Строка с результатами (количество, минимум, максимум, сумма, среднее).
     */
    public Statistics calculateInteger(List<Integer> numbers) {
        int count = numbers.size();
        if (count == 0) {
            return new Statistics(0, 0, 0, 0, 0);
        }

        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;
        long sum = 0;// использую лонг для суммы, чтобы избежать переполнения

        for (Integer number : numbers) {

            if (number < min) {
                min = number;
            }
            if (number > max) {
                max = number;
            }
            sum += number;
        }

        double average = (double) sum / count;
        return new Statistics(count, min, max, sum, average);
    }

    /**
     * Вычисляет статистику для вещественных чисел
     * @param numbers список вещественных чисел
     * @return Строка с результатами (количество, минимум, максимум, сумма, среднее).
     */

    public Statistics calculateDouble(List<Double> numbers) {
        int count = numbers.size();
        if (count == 0) {
            return new Statistics(0, 0, 0, 0, 0);
        }
        double min = Double.MIN_VALUE;
        double max = Double.MAX_VALUE;
        double sum = 0;

        for (Double number : numbers) {

            if (number < min) {
                min = number;
            }
            if (number > max) {
                max = number;
            }
            sum += number;
        }
        double average = sum / count;
        return new Statistics(count, min, max, sum, average);
    }

    /**
     * Вычисляет статистику для списка строк:
     *
     * @param strings Список строк
     * @ return Строка с результатами(количество, размер самой длинной строки, и самой короткой строки)
     */
    public Statistics calculateString(List<String> strings) {
        int count = strings.size();
        if (count == 0) {
            return new Statistics(0, 0, 0);
        }
        int shortestLength = Integer.MAX_VALUE;
        int longestLength = 0;

        for (String str : strings) {
            int length = str.length();
            if (length < shortestLength) {
                shortestLength = length; //обновляем длину самой короткой строки
            }
            if (length > longestLength) {
                longestLength = length;
            }
        }
        return new Statistics(count, shortestLength, longestLength);
    }
}
