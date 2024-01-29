package api;

import org.apache.commons.csv.*;
import org.testng.annotations.DataProvider;
import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class CsvDataProvider {

    @DataProvider(name = "csvDataProvider")
    public static Object[][] createDataFromCsv() {
        List<Object[]> data = new ArrayList<>();
        try (Reader in = new FileReader("data.csv")) {
            Iterable<CSVRecord> records = CSVFormat.DEFAULT.parse(in);
            for (CSVRecord record : records) {
                String column1 = record.get(0);
                String column2 = record.get(1);
                data.add(new Object[]{column1, column2});
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data.toArray(new Object[0][]);
    }
}
