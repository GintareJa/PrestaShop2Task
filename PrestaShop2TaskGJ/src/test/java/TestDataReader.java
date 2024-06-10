import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
public class TestDataReader {
    public static List<String[]> readCSVData(String filePath) throws IOException {
        List<String[]> records = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        String line;
        boolean isFirstLine = true;
        while ((line = br.readLine()) != null) {
            if (isFirstLine) {
                isFirstLine = false;
                continue; // skip the header
            }
            String[] fields = line.split(",");
            records.add(fields);
        }
        br.close();
        return records;
    }
}

