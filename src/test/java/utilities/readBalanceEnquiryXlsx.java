package utilities;

import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class readBalanceEnquiryXlsx {

    @DataProvider(name = "balance")
    public Object[][] balanceEnquiry() throws IOException {

        File file = new File(System.getProperty("User.dir") + "\\src\\test\\resources\\testdata\\NewAccountData.xlsx");
        FileInputStream fis = new FileInputStream(file);
        Workbook wb = WorkbookFactory.create(fis);
        Sheet sheet = wb.getSheetAt(4);

        //Get total number of rows
        int totalRows = sheet.getLastRowNum();
        System.out.println(totalRows);

        DataFormatter format = new DataFormatter();

        String testData[][] = new String[totalRows][1];

        for (int i=1; i<=totalRows; i++) {

            Row row = sheet.getRow(i);

            String cellValue = format.formatCellValue(row.getCell(0));
            testData[i][0] = cellValue;
        }
        return testData;
    }
}
