import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public final class WriteFiles {
    /**
     *  записывает данные в файл:
     * @param filePath к файлу, в который будут записаны данные
     * @param data данные для записи
     * @param append  Если true - данные будут записаны в конец файла, если false - файл перезапишется
     * @throws IOException если произошла ошибка при записи
     */
    public void writeToFile(String filePath, List<?> data, boolean append) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, append))) {
            for (Object item : data) {
                writer.write(item.toString());//записываем каждый элемент
                writer.newLine();//переход на новую строку
            }
        }

    }
    /**
     * Генерирует имя файла на основе пути, префикса и стандартного имени.
     * @param outputPath путь к дирректории
     * @param prefix префикс имени файла
     * @param suffix стандартное имя файла
     * @return полное имя файла
     */

    public String generateFileName(String outputPath, String prefix, String suffix) {
        //если путь для вывода не указан, используем текущую дирректорию
        if(outputPath == null || outputPath.isEmpty()) {
            return prefix + suffix;
        } else {
            //нужно убедиться, что путь заканчивается на "/"  или "\"
            if(outputPath.endsWith(File.separator)) {
                outputPath +=File.separator;
            }
        }
        return outputPath + prefix + suffix;
    }
}
