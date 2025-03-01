import java.util.List;

public final class FilteredData {
    private final List<Integer> integers;
    private final List<String> strings;
    private final List<Double> doubles;

    public FilteredData(List<Integer> integers,List<String> strings, List<Double> doubles) {
        this.integers = integers;
        this.strings = strings;
        this.doubles = doubles;
    }
    public List<Integer> getIntegers() {return integers;}
    public List<Double> getDoubles() {return doubles;}
    public List<String> getStrings() {return strings;}
}
