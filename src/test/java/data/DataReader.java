package data;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import com.opencsv.exceptions.CsvValidationException;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class DataReader {
    static FileInputStream FIS = null;
    CSVReader reader; // reader from opnCSV library

    public static FileInputStream getFIS() {

        String filePath = System.getProperty("user.dir") + "\\src\\test\\java\\data\\userData.xlsx";
        File srcFile = new File(filePath);
        try {
            FIS = new FileInputStream(srcFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Test data file not found: " + e.getMessage());
        }
        return FIS;

    }

    public Object[][] getExcelData() throws IOException {
        FIS = getFIS();
        XSSFWorkbook workbook = new XSSFWorkbook(FIS);
        XSSFSheet sheet = workbook.getSheetAt(0);

        int TotalNumOfRows = (sheet.getLastRowNum() + 1);
        int TotalNumOfCols = 4; // known and it's number of parameters sent to method

        String[][] arrayExcelData = new String[TotalNumOfRows][TotalNumOfCols];

        for (int i = 0; i < TotalNumOfRows; i++) {
            for (int j = 0; j < TotalNumOfCols; j++) {
                XSSFRow row = sheet.getRow(i);
                arrayExcelData[i][j] = row.getCell(j).toString();
            }
        }

        workbook.close();
        return arrayExcelData;
    }

    public Object[][] getCSVData() throws IOException, CsvException {
        // get path of the CSV
        String CSV_file = System.getProperty("user.dir") + "\\src\\test\\java\\data\\userData2.csv";

        reader = new CSVReader(new FileReader(CSV_file));
        // to know rows count
        List<String[]> records = reader.readAll();

        int rowsCount = records.size();
        int colsCount = 3; // known and it's number of parameters sent to method

        // string array to hold all values
        String[][] arrayCSVData = new String[rowsCount][colsCount];
        int row = 0;

        for(String[] listArrayRow : records) {
            arrayCSVData[row] = listArrayRow; // fill the string array
            row++;
        }
        return arrayCSVData;
    }

}
