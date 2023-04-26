package utilities;

import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;

public class readXlsData {

    @DataProvider(name = "bvtData")
    public Object[][] getData() throws IOException {


        //String excelSheetName = m.getName();
        File file = new File(System.getProperty( "user.dir") + "\\src\\test\\resources\\testdata\\NewAccountData.xlsx");
        FileInputStream fis = new FileInputStream(file);
        Workbook wb = WorkbookFactory.create(fis);
        Sheet sheetName = wb.getSheetAt(0);

        //get total number of rows and columns dynamically
        int totalRows = sheetName.getLastRowNum();
        System.out.println(totalRows);

        //total cell count
        Row rowCells = sheetName.getRow(0);

        //total columns
        int totalCol = rowCells.getLastCellNum();
        System.out.println(totalCol);

        //format whatever data to be string
        DataFormatter format = new DataFormatter();

        String testData[][] = new String[totalRows][totalCol];

        for(int i = 1; i<=totalRows; i++){
            for(int j= 0; j < totalCol; j++){

                testData[i-1][j] = format.formatCellValue(sheetName.getRow(i).getCell(j));
                System.out.println(testData[i-1][j]);

            }
        }


        return testData;
    }
}
