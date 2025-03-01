import java.io.File;
import java.util.ArrayList;
import java.util.List;

public final class ArgumentParser {
    private List<String> inputFiles = new ArrayList<>();
    private String outputPath = ".";// по умолчанию текущая директория
    private String prefix = "";//пустой префикс по умолчанию
    private boolean append = false;//по умолчанию режим перезаписи
    private boolean shortStats = false;// по умолчанию статистика не активна
    private boolean fullStats = false;// по умолчанию статистика не активна

    /**
     * Парсит аргумент командной строки
     * @param args Аргументы командной строки
     * @throws IllegalArgumentException Если аргументы не корректны
     */
    public void parseArgs(String[] args) throws IllegalArgumentException {
        inputFiles = new ArrayList<>();
        for (int i = 0; i < args.length; i++) {
            if(args[i].startsWith("-")) {
                //// Обработка опций (-o, -p, -a и т.д.)

                switch (args[i]) {
                    case "-o":
                    case "output":
                        if (i + 1 < args.length) {
                            outputPath = args[i + 1];// след.аргумент -путь для вывода
                            i++;//пропускаем след. аргумент, т.к. он уже обработан
                        } else {
                            throw new IllegalArgumentException("Не указан путь для выходных файлов после опции -о");
                        }
                        break;
                    case "-p":
                    case "--prefix":
                        if (i + 1 < args.length) {
                            prefix = args[i + 1];// след.аргумент префикс
                            i++;
                        } else {
                            throw new IllegalArgumentException("Не указан префикс после опции -p");
                        }
                        break;
                    case "-a":
                    case "--append":
                        append = true; // вкл режим добавления
                        break;
                    case "-s":
                    case "--shortStats":
                        shortStats = true; // вкл режим краткой статистики
                        break;
                    case "-f":
                    case "--fullStats":
                        fullStats = true; // вкл полную статистику
                        break;
                    default:
                        throw new IllegalArgumentException("Неизвестная опция :" + args[i]);
                }
            } else {
                //извлекаем только имя файла(без пути)
                String fileName = new File(args[i]).getName();
                inputFiles.add(fileName);

            }

        }
        //проверка, что указаны входные файлы
        if(inputFiles.isEmpty()) {
            throw new IllegalArgumentException("Не указаны входные файлы.");
        }
    }
    public List<String> getInputFiles() {return inputFiles;}

    public String getOutputPath() {return outputPath;}

    public String getPrefix() {return prefix;}

    public boolean isAppend() {return append;}

    public boolean isFullStats() {return fullStats;}

    public boolean isShortStats() {return shortStats;}
}
