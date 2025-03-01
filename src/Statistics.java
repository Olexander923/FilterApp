public final class Statistics {
    /**
     * класс хранит все необходимые данные для подсчета статистики
     */
    private int count;//количество элементов
    private double max;// максимальное значение
    private double min;//минимальное значение
    private double sum; //сумма
    private double average;//среднее значение
    private int longestLength; //длина самой длинной строки(только для строк)
    private int shortestLength;// длина самой короткой строки(только для строк)

    public Statistics(int count, double max, double min,double sum,double average) {
        this.count = count;
        this.max = max;
        this.min = min;
        this.sum = sum;
        this.average = average;
    }
    public Statistics(int count,int longestLength,int shortestLength) {
        this.count = count;
        this.longestLength = longestLength;
        this.shortestLength = shortestLength;
    }
    public int getCount() {return count;}
    public double getMax() {return max;}
    public double getMin() {return min;}
    public double getSum() {return sum;}
    public double getAverage() {return average;}
    public int getLongestLength() {return longestLength;}
    public int getShortestLength() {return shortestLength;}
}
