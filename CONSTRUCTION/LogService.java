import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class LogService {
    private final List<String> logs = new ArrayList<>();


    public void add(String msg) {
        logs.add(msg);
    }


    public void export(String fileName) {
        try (FileWriter fw = new FileWriter(fileName)) {
            for (String s : logs) fw.write(s + System.lineSeparator());
        } catch (IOException e) {
            System.out.println("Log export error: " + e.getMessage());
        }
    }
}