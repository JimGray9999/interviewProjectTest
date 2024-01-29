package api;

import org.apache.commons.csv.*;
import org.testng.annotations.DataProvider;
import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

// code snippets sourced from researching how to setup a data provider using CSV files
public class CsvDataProvider {
    @DataProvider(name = "csvDataProvider")
    public static Object[][] createDataFromCsv() {
        List<Object[]> data = new ArrayList<>();
        try (Reader in = new FileReader("data.csv")) {
            Iterable<CSVRecord> records = CSVFormat.DEFAULT.parse(in);
            for (CSVRecord record : records) {
                String column1 = record.get(0);
                String column2 = record.get(1);
                String column3 = record.get(2);
                String column4 = record.get(3);
                data.add(new Object[]{column1, column2, column3, column4});
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data.toArray(new Object[0][]);
    }
}
