import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            //парсинг аргументов командной строки
            ArgumentParser parser = new ArgumentParser();
            parser.parseArgs(args);

            // чтение файлов
            ReadFiles read = new ReadFiles();
            List<String> allLines = new ArrayList<>();
            for (String inputFile : parser.getInputFiles()) {
                allLines.addAll(read.readFile(inputFile));
            }
            // фильтрация данных
            DataFilter filter = new DataFilter();
            FilteredData filteredData = filter.filterData(allLines);

            // генерируем путь для выходных файлов
            WriteFiles fileWriter = new WriteFiles();
            String integersFilePath = fileWriter.generateFileName(parser.getOutputPath(), parser.getPrefix(), "integers.txt");
            String floatsFilePath = fileWriter.generateFileName(parser.getOutputPath(), parser.getPrefix(), "floats.txt");
            String stringsFilePath = fileWriter.generateFileName(parser.getOutputPath(), parser.getPrefix(), "strings.txt");

            //запись данных в файлы
            if (!filteredData.getIntegers().isEmpty()) {
                fileWriter.writeToFile(integersFilePath, filteredData.getIntegers(), parser.isAppend());
            }
            if (!filteredData.getDoubles().isEmpty()) {
                fileWriter.writeToFile(floatsFilePath, filteredData.getDoubles(), parser.isAppend());
            }
            if (!filteredData.getStrings().isEmpty()) {
                fileWriter.writeToFile(stringsFilePath, filteredData.getStrings(), parser.isAppend());
            }

            // сбор и вывод статистики
            StatisticsCollector statistics = new StatisticsCollector();
            StatisticsPrinter printer = new StatisticsPrinter();
            if (parser.isShortStats() || parser.isFullStats()) {
                if (!filteredData.getIntegers().isEmpty()) {
                    Statistics intStats = statistics.calculateInteger(filteredData.getIntegers());
                    System.out.println("Статистика для целых чисел: ");
                    printer.printStatistics(intStats, parser.isFullStats());

                }
                if (!filteredData.getDoubles().isEmpty()) {
                    Statistics doublesStats = statistics.calculateDouble(filteredData.getDoubles());
                    System.out.println("Статистика для вещественных чисел: ");
                    printer.printStatistics(doublesStats, parser.isFullStats());

                }
                if (!filteredData.getStrings().isEmpty()) {
                    Statistics stringsStats = statistics.calculateString(filteredData.getStrings());
                    System.out.println("Статистика для строк:");
                    printer.printStatistics(stringsStats, parser.isFullStats());
                    printer.printStatistics(stringsStats, parser.isShortStats());
                }
            }
        } catch (IllegalArgumentException e) {
            System.err.println("Ошибка:" + e.getMessage());
        } catch (Exception e) {
            System.err.println("Неизвестная ошибка:" + e.getMessage());
        }
    }
}