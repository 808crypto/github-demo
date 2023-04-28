package utilities;

import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class readXlsFundTransfer {

    @DataProvider(name = "fundTransfer")
    public Object [][][][] fundTransferData() throws IOException {

        File file = new File(System.getProperty("User.dir") + "\\src\\test\\resources\\testdata\\NewAccountData.xlsx");
        FileInputStream fis = new FileInputStream(file);
        Workbook wb = WorkbookFactory.create(fis);
        Sheet sheet = wb.getSheetAt(3);

        //get total number of rows and columns
        int totalRows = sheet.getLastRowNum();
        System.out.println(totalRows);

        //get number of cells
        Row rowCells = sheet.getRow(0);

        //get number of column
        int totalCol = rowCells.getLastCellNum();

        //format data to string
        DataFormatter format = new DataFormatter();

        String testData[][][][] = new String[totalRows][totalCol][2][1];

        for(int i = 1; i <= totalRows; i++) {
            Row row = sheet.getRow(i);
            for (int j = 0; j < totalCol; j++) {
                Cell cell = row.getCell(j);

                testData[i-1][j][0][1] = format.formatCellValue(cell);
                testData[i-1][j][1][1] = format.formatCellValue(row.getCell(j+1));

                System.out.println(testData[i-1][j][0][1] + " " + testData[i-1][j][1][1]);

            }
        }

        return testData;
    }

}
