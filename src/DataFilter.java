import java.util.ArrayList;
import java.util.List;

public final class DataFilter {
    /**
     * класс фильтрации с методами для классификации данных
     */
    private boolean isInteger(String value) {//проверяет является ли строка целым числом
        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    private boolean isDouble(String value) {//проверяет является ли строка вещественным числом
        try {
            Double.parseDouble(value);
            return true;
        } catch(NumberFormatException e) {
            return false;
        }
    }
    public FilteredData filterData(List<String> data) {
        List<Integer> integers = new ArrayList<>();
        List<String> strings = new ArrayList<>();
        List<Double> doubles = new ArrayList<>();

        for(String line : data) {
            if(line == null || line.trim().isEmpty()) {
                continue;// пропуская пустые стоки
            }
            if(isInteger(line)) {
                integers.add(Integer.parseInt(line));
            } else if (isDouble(line)) {
                doubles.add(Double.parseDouble(line));
            } else {
                strings.add(line);
            }
        }
        return new FilteredData(integers, strings,doubles);
    }
}

