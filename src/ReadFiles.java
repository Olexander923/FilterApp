import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public final class ReadFiles {
    public List<String> readFile(String fileName) throws IOException {
        List<String> listStrings = new ArrayList<>();

        // Используем ClassLoader для загрузки файла как ресурса
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(fileName);
        if (inputStream == null) {
            System.err.println("Файл не найден: " + fileName);
            throw new IOException("Файл не найден: " + fileName);
        } else {
            System.out.println("Файл успешно загружен: " + fileName);
        }

        try(BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = reader.readLine()) != null) {
                listStrings.add(line);
            }
        }

        return listStrings;
    }
}
